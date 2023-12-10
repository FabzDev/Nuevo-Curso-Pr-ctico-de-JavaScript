
package com.fabzdev.txtFormat;

import java.io.File;


public class ListFiles {
    public static StringBuilder sb = new StringBuilder();
    
    public static String stringFormat(String str, int len){
        sb.delete(0, sb.length());
        sb.append(str);
        while(sb.length() < len)
            sb.append(" ");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        File dir = new File("C:/TheJavaPathV2/learnJava");
        File[] files = dir.listFiles();
        int textLen = 0;
        StringBuilder nsb = new StringBuilder();
        for (File f : files)
            textLen = Math.max(textLen, f.getName().length());
        
        textLen += 2;
        
        nsb.append(stringFormat("Nombre", textLen));
        nsb.append(stringFormat("Tipo", 12));
        nsb.append(stringFormat("Tamaño", 8));
        nsb.append("\n");
        for (int i=0; i<textLen+25; i++)
            nsb.append("-");
        nsb.append("\n");
        
        for (File f : files){
            nsb.append(stringFormat(f.getName(), textLen));
            nsb.append(stringFormat(f.isFile() ? "File": "Directory", 12));
            nsb.append(stringFormat(String.valueOf(f.length()), 8));
            nsb.append("\n");
        }
        
        System.out.println(nsb);
        
        
    }
}
