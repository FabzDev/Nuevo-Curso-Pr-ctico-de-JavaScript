package com.fabzdev.dataStructures;

import java.io.File;

/**
 *
 * @author fabio
 */
public class RecursiveDir {

    public void printDir(File file) {
        
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                printDir(f);
            }
        }
    }

    public static void main(String[] args) {
        RecursiveDir rd = new RecursiveDir();
        rd.printDir(new File("d:/SENA"));
    }
}
