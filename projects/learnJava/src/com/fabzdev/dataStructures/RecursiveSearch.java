package com.fabzdev.dataStructures;

import java.io.File;

/**
 *
 * @author fabio
 */
public class RecursiveSearch {

    private void getFilePath(String str, File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                getFilePath(str, f);
            }
        } else {
            if (str.equals(file.getName())) {
                System.out.println(file.getAbsolutePath());
                return;
            } 
        }
    }

    public static void main(String[] args) {
        RecursiveSearch rs = new RecursiveSearch();
        rs.getFilePath("1- Course Outline.mp4", new File("d:/Descargas"));
    }
}
