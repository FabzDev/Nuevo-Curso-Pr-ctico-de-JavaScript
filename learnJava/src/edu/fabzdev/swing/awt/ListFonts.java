/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.fabzdev.swing.awt;

import java.awt.GraphicsEnvironment;

/**
 *
 * @author fabio
 */
public class ListFonts {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] familyFonts = ge.getAvailableFontFamilyNames();
        
        for(String font : familyFonts){
            System.out.println(font);
        }
    }
}
