package edu.fabzdev.dataStructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    public void unzip(File zipFile, File folderDest) {
        try (InputStream zip = new FileInputStream(zipFile); ZipInputStream zipStream = new ZipInputStream(zip)) {
            ZipEntry entry = zipStream.getNextEntry();
            while (entry != null) {
                String entryName = entry.getName();
                if (!entry.isDirectory()) {
                File fileDest = new File("c:/TheJavaPathV2/testZip/" + entryName);
                    if (!fileDest.getParentFile().exists()) {
                        fileDest.getParentFile().mkdirs();
                    }
                    try (FileOutputStream OutputFileDest = new FileOutputStream(fileDest);) {
                        //CON BUFFER
                        byte[] buffer = new byte[4096];
                        int n = zipStream.read(buffer);
                        while (n != -1) {
                            OutputFileDest.write(buffer, 0, n);
                            n = zipStream.read(buffer);
                        }
                        //SIN BUFFER
//                        int n = zipStream.read();
//                        while (n !=  -1) {
//                            OutputFileDest.write(n);
//                            n = zipStream.read();
//                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }

                }
                entry = zipStream.getNextEntry();
            }
        } catch (IOException ex) {
            Logger.getLogger(ZipRecursive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        ZipRecursive zipR = new ZipRecursive();

//        File srcDir = new File("c:/TheJavaPathV2/stream.txt");
//        File zipFile = new File("c:/TheJavaPathV2/stream.zip");
//        zipR.createZip(srcDir, zipFile);
        File fileToUnzip = new File("c:/TheJavaPathV2/stream.zip");
        File folderWhereUnzip = new File("c:/TheJavaPathV2/testZip");

        zipR.unzip(fileToUnzip, folderWhereUnzip);
    }
}
