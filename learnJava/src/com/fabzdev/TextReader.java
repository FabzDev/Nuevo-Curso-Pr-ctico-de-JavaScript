
package com.fabzdev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class TextReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:/TheJavaPathV2/learnJava/src/com/fabzdev/quijote.txt")));
        String line = br.readLine();
        while(line != null){
            System.out.println(line);
            line = br.readLine();
        }
    
    }
    
}
