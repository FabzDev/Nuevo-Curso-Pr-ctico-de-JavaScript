/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.lambda;

import java.util.Arrays;

/**
 *
 * @author fabio
 */
public class MethodReference2 {
    public static void main(String[] args) {
        String letters[] = {"G", "f", "x","o", "Z","y", "C","e"};
        System.out.println(Arrays.toString(letters));
        Arrays.sort(letters, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(letters));
    }
}
