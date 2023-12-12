package edu.fabzdev.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArbolValidaton {

    public static void main(String[] args) throws IOException {
        boolean active = true;
        do {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digita el tamaño del arbol");
            String sizeString = br.readLine();

            try {
                int size = Integer.parseInt(sizeString);
                hojas(size);
                active = false;
            } catch (Exception e) {
                System.out.println("El numero ingresado no es valido, por favor intentalo de nuevo");
                System.out.println();
            }

        } while (active);
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
