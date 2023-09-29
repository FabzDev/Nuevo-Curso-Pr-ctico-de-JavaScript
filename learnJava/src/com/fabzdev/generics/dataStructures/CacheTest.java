/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.generics.dataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author fabio
 */
public class CacheTest {

    public static void main(String[] args) throws Exception{
        CacheTest.run();
    }

    public static void run() throws Exception {
        Set<String> wordList = new HashSet<>();
        int nWords = 0;
        int nLines = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(CacheTest.class.getResourceAsStream("/com/fabzdev/quijote.txt")));
        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()) {
                String word = st.nextToken().trim();
                System.out.print(word + " ");
                wordList.add(word);
                nWords++;
            }
            System.out.println();
            line = br.readLine();
            nLines++;
        }
        br.close();
        
         System.out.println("Total lines: " + nLines);
        System.out.println("Distinct words: " + wordList.size());
        System.out.println("Total words: " + nWords);
    }
}
