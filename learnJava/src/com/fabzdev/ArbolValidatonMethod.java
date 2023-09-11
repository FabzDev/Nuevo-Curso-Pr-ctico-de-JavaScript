package com.fabzdev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArbolValidatonMethod {

    public static void main(String[] args) throws IOException {

        int size = getSize();
        hojas(size);
    }

    public static int getSize() {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digita el tamaño del arbol");
            try {
                String sizeString = br.readLine();
                return Integer.parseInt(sizeString);
            } catch (Exception e) {
                System.out.println("El numero ingresado no es valido, por favor intentalo de nuevo");
                System.out.println();
            }

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
