package com.fabzdev.dataStructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
//    private void unzipFile(File folderToUnzip, ZipInputStream zipFile) throws IOException {
//        ZipEntry zipEntry = zipFile.getNextEntry();
//        
//        byte[] buffer = new byte[4096];
//        try (OutputStream out = new FileOutputStream(zipEntry)) {
//            out.write(buffer, 0, 0);
//        }
//    }

    private void Unzip(File fileToUnzip, File folderWhereUnzip) throws IOException {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(fileToUnzip))) {
            ZipEntry zipEntry = zin.getNextEntry();
            while (zipEntry != null){
            FileOutputStream out = new FileOutputStream(folderWhereUnzip);
            out.write(zipEntry.);
            }
            
        }
    }

    public static void main(String[] args) throws IOException {
//        File srcDir = new File("c:/TheJavaPathV2/testZip");
//        File zipFile = new File("c:/TheJavaPathV2/result.zip");

        ZipRecursive zipR = new ZipRecursive();
//        zipR.createZip(srcDir, zipFile);

        File fileToUnzip = new File("c:/TheJavaPathV2/result.zip");
        File folderWhereUnzip = new File("c:/TheJavaPathV2/result");

        zipR.Unzip(fileToUnzip, folderWhereUnzip);
    }

}
