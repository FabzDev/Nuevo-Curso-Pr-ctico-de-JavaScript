package edu.fabzdev.dataStructures;

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
    
    public void printPath(File file) {
        
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                printPath(f);
            }

        }
    }

    public static void main(String[] args) {
        RecursiveDir rd = new RecursiveDir();
//        rd.printDir(new File("d:/SENA"), 0);
        rd.printPath(new File("d:/SENA"));
    }
}
