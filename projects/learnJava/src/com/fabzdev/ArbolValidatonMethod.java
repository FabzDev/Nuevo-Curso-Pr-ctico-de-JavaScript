package com.fabzdev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArbolValidatonMethod {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = getSize(br, "Digita el tamaño del arbol", "El numero ingresado no es valido, por favor intentalo de nuevo");
        hojas(size);
    }

    public static int getSize(BufferedReader br, String message1, String message2 ) throws IOException {
        while (true) {
            System.out.println(message1);
                String sizeString = br.readLine();
            try {
                return Integer.parseInt(sizeString);
            } catch (Exception e) {
                System.out.println(message2);
                System.out.println();
            }
            br.close();
        }
    }

    public static void hojas(int n) {
        // Dibujando ramas
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n * 2; j++) {
                if ((j >= n - i) && (j <= n + i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Dibujando el tallo
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= n * 2; j++) {
                if (j == (n - 1) || j == (n + 1)) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
