
package com.fabzdev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleStream {
    public static void main(String[] args) throws IOException {
        BufferedReader bs =  new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Cual es tu nombre?");
        String line = bs.readLine();
        System.out.println("Hola " + line + "!");
    }
}
