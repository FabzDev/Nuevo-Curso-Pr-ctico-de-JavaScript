package com.fabzdev.dataStructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author fabio
 */
public class ZipRecursive {

    private void addFileToZip(File file, String fileName, ZipOutputStream zout) throws IOException {
        ZipEntry zipEntry = new ZipEntry(fileName);
        zout.putNextEntry(zipEntry);
        byte[] buffer = new byte[4096];
        try (InputStream in = new FileInputStream(file)) {
            int n = in.read(buffer);
            while (n != -1) {
                zout.write(buffer, 0, n);
                n = in.read(buffer);
            }
        }
    }

    private void recursiveAddFileToZip(File srcDir, String fileName, ZipOutputStream zout) throws IOException {
        fileName = fileName.length() > 0 ? fileName + "/" + srcDir.getName() : srcDir.getName();
        if (srcDir.isDirectory()) {
            File[] files = srcDir.listFiles();
            for (File f : files) {
                recursiveAddFileToZip(f, fileName, zout);
            }
        } else {
            addFileToZip(srcDir, fileName, zout);
            System.out.println(fileName);
        }
    }

    private void createZip(File srcDir, File zipFile) throws IOException {
        if (zipFile.exists()) {
            throw new IOException("El archivo " + zipFile.getAbsolutePath() + " ya existe");
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipFile))) {
            recursiveAddFileToZip(srcDir, "", zout);
        }
    }

    //UNZIP
    public void unzip(File zipFile, File folder) {
        try (InputStream zip = new FileInputStream(zipFile); ZipInputStream zipStream = new ZipInputStream(zip)) {
            ZipEntry entry = zipStream.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                if (entry.isDirectory()) {
                    File dest = new File(folder, fileName);
                    if (!dest.mkdirs()) {
                        throw new IOException("mkdirs: ");
                    }

                } else {
                    File dest = new File(folder, fileName);
                    if (!dest.getParentFile().exists()) {
                        if (!dest.getParentFile().mkdirs()) {
                            throw new IOException("mkdirs: ");
                        }
                    }
                }
                try (FileOutputStream out = new FileOutputStream(folder);) {
                    byte[] bytes = new byte[4096];
                    int n = zipStream.read(bytes);
                    while (n != -1) {
                        out.write(bytes, 0, n);
                    }
                    n = zipStream.read(bytes);

                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }
            entry = zipStream.getNextEntry();
        } catch (IOException ex) {
            Logger.getLogger(ZipRecursive.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) throws IOException {
//        File srcDir = new File("c:/TheJavaPathV2/testZip");
//        File zipFile = new File("c:/TheJavaPathV2/result.zip");

        ZipRecursive zipR = new ZipRecursive();
//        zipR.createZip(srcDir, zipFile);

        File fileToUnzip = new File("c:/TheJavaPathV2/result.zip");
        File folderWhereUnzip = new File("C:/TheJavaPathV2/");

        zipR.unzip(fileToUnzip, folderWhereUnzip);
    }

}
