/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fabio
 */
public class WordCount {
     public Map<String, Integer> phrase(String input) {
        Map<String,Integer> result = new HashMap<>();
        String words[] = input.split("[\\p{Blank}]");
        for(String word: words){
            word = word.toLowerCase().replaceAll("[^a-z0-9']|^'|'[^a-z0-9']+$", "");
            System.out.println(word);
        }
        
        return result;
    }
     
     public static void main(String[] args) {
        new WordCount().phrase("\"That's the password: 'PASSWORD 123'!\", cried the Special Agent.\nSo I fled.");
    }
}
