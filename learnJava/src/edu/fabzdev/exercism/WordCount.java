/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.exercism;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fabio
 */
public class WordCount {

    Map<String, Integer> result = new HashMap<>();

    public Map<String, Integer> phrase(String input) {
        String words[] = input.split("\\s|,");
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-z0-9']|^'|'$", "");
            if(result.containsKey(word)){
                result.put(word, result.get(word)+1);
            } else if(!("".equals(word))){
                result.put(word, 1);                
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WordCount wc = new WordCount();
        wc.phrase("one,two,three");
        System.out.println(wc.result);
    }
}
