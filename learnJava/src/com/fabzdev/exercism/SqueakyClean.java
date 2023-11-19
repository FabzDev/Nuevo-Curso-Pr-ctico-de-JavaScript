/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class SqueakyClean {

    static String clean(String identifier) {
        String newId;
        newId = identifier.replace(' ', '_');
        newId = newId.replaceAll("[\\p{Cntrl}]", "CTRL");
        newId = kebabToCamel(newId);
        newId = removeGreeks(newId);
        return newId;
    }

    static String kebabToCamel(String str) { // free-Palestine-from-Israel
        StringBuilder sb = new StringBuilder();
        String frags[] = str.split("-");
        for (String s : frags) {
            char[] mot = s.toCharArray();
            if (sb.length() > 0) {
                mot[0] = Character.toUpperCase(mot[0]);
                for (char c : mot) {
                    if(c == '_'){
                        sb.append(c);
                    } else if (Character.isLetter(c)) {
                        sb.append(c);
                    }
                }
            } else {
                for (char c : mot) {
                    if(c == '_'){
                        sb.append(c);
                    } else if (Character.isLetter(c)) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
    
    static String removeGreeks(String str){
        return str.replaceAll("[\\u03B1-\\u03C9]","");
    }

    public static void main(String[] args) {
        //"_AbcĐCTRL"
        System.out.println(SqueakyClean.clean("9 -abcĐ\uD83D\uDE00ω\0"));
    }
}
