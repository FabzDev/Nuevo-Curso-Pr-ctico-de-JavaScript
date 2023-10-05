package com.fabzdev.dataStructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
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
        try(InputStream in = new FileInputStream(file)){
            int n = in.read(buffer);
            while(n != -1){
                zout.write(buffer, 0, n);
                n = in.read(buffer);
            }
        }
    }

    private void recursiveAddFileToZip(File srcDir, String fileName, ZipOutputStream zout) throws IOException {
        fileName = fileName.length() > 0 ? fileName + "/" + srcDir.getName() : srcDir.getName();
        if(srcDir.isDirectory()){
            File[] files = srcDir.listFiles();
            for (File f : files) {
                recursiveAddFileToZip(f, fileName, zout);
            }
        }else {
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

    public static void main(String[] args) throws IOException {
        File srcDir = new File("c:/TheJavaPathV2/testZip");
        File zipFile = new File("c:/TheJavaPathV2/result.zip");

        ZipRecursive zipR = new ZipRecursive();
        zipR.createZip(srcDir, zipFile);
    }

    

    

}
