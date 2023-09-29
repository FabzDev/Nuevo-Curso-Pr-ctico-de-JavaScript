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

    class Cache {
        CacheNode head;
        int size = 0;
        int count = 0;

        public CacheNode getNode(String word) {
            if (head == null) {
                return agregarNuevoNodo(word);
            } else {
                boolean encontrado = nodoEncontrado(word);
                if (encontrado) {
                    return reubicarNodoInicio(word);
                } else {
                    if (count > size + 1) {
                        eliminarUltimoNodo();
                    }
                    return agregarNuevoNodo(word);
                }
            }
        }
    

    public CacheNode agregarNuevoNodo(String word) {
        CacheNode nodo = new CacheNode(word);
        nodo.next = head.next;
        head = nodo;
        count++;
        return nodo;

    }

    public CacheNode reubicarNodoInicio(String word) {
        CacheNode prev = head;
        CacheNode temp = head;
        while (temp != null) {
            if (temp.word.equals(word)) {
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        temp.next = head;
        head = temp;
        return temp;
    }

    public boolean nodoEncontrado(String word) {
        CacheNode temp = head;
        boolean encontrado = false;

        while (temp != null) {
            if (temp.word.equals(word)) {
                encontrado = true;
                break;
            }
            temp = temp.next;
        }
        return encontrado;
    }

    public void eliminarUltimoNodo() {
        CacheNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        count--;
    }

}

class CacheNode {

    public String word;
    public CacheNode next;
    public CacheNode prev;

    public CacheNode(String word) {
        this.word = word;
    }
}

class SlowWord {

    String word;

    public SlowWord(String word) {
        this.word = word;
        try {
            Thread.sleep(50);
            System.out.println(word);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getWord() {
        return word;
    }
}

public static void main(String[] args) throws Exception {
        new CacheTest().run();
    }

    public void run() throws Exception {
        Set<String> wordList = new HashSet<>();
        int nWords = 0;
        int nLines = 1;
        BufferedReader

br = new BufferedReader(new InputStreamReader(CacheTest.class  

.getResourceAsStream("/com/fabzdev/quijote.txt")));
        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()) {
                String word = st.nextToken().trim();

                SlowWord sw = new SlowWord(word);

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
