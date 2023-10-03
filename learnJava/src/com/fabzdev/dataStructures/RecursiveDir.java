package com.fabzdev.dataStructures;

import java.io.File;

/**
 *
 * @author fabio
 */
public class RecursiveDir {

    public void printDir(File file, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            level++;
            File[] files = file.listFiles();
            for (File f : files) {
                printDir(f, level);
            }

        }
    }

    public static void main(String[] args) {
        RecursiveDir rd = new RecursiveDir();
        rd.printDir(new File("d:/SENA"), 0);
    }
}
