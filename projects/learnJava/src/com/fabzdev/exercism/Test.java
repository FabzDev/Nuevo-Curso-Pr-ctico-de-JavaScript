/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class Test {
    public static void main(String[] args) {
        String originalString = "my\0\r\u007FId";

        // Use a regular expression to match control characters
        String replacedString = originalString.replaceAll("[\\p{Cntrl}]", "CTRL");

        System.out.println("Original String: " + originalString);
        System.out.println("Replaced String: " + replacedString);
    }
}
