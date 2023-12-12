package edu.fabzdev.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileTest {

    public static void copyFile(File src, File dest) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dest);
        int b = in.read();
        while (b != -1) {
            out.write(b);
            b = in.read();
        }
        in.close();
        out.close();
    }
    
     public static void copyFile2(File src, File dest) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dest);
        byte[] buffer = new byte[4096];
        int b = in.read(buffer);
        while (b != -1) {
            out.write(buffer, 0, b);
            b = in.read();
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        File fileSrc = new File("C:/TheJavaPathV2/fabio.png");
        File fileDest = new File("C:/TheJavaPathV2/fabio3.png");
        copyFile2(fileSrc, fileDest);
    }
}
