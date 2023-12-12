
package edu.fabzdev.others;

import java.util.Scanner;


public class ConsoleScanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Como te llamas?");
        String line = scan.nextLine();
        System.out.println("Hola " +line+ "!");
    }
}
