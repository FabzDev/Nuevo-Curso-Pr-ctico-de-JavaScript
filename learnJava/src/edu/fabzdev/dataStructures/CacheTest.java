/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.dataStructures;

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

        public Cache(int size){                                         
            this.size = size;
        }
        
        public SlowWord getSlowWord(String word){
            if(nodoEncontrado(word)){
                return reubicarNodoInicio(word);
            } else {
                SlowWord nuevoSw = new SlowWord(word);
                agregarNuevoNodo(new CacheNode(nuevoSw));
                if(count>size)
                    eliminarUltimoNodo();
                return nuevoSw;
            }
        }

        public void agregarNuevoNodo(CacheNode node) {
            if(head == null){
                head = node;
                return;
            }                
            node.next = head;
            head = node;
            count++;
        }

        public SlowWord reubicarNodoInicio(String word) {
            CacheNode prev = head;
            CacheNode temp = head;
            while (temp != null) {
                if (temp.slowWord.word.equals(word)) {
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = head;
            head = temp;
            return head.slowWord;
        }

        public boolean nodoEncontrado(String word) {
            CacheNode temp = head;
            while (temp != null) {
                if (temp.slowWord.word.equals(word)) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        public void eliminarUltimoNodo() {
            CacheNode prev = head;
            CacheNode temp = head;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            count--;
        }

    }

    class CacheNode {
        public SlowWord slowWord;
        public CacheNode next;

        public CacheNode(SlowWord slowWord) {
            this.slowWord = slowWord;
        }
    }

    class SlowWord {
        String word;
        
        public SlowWord(String word) {
            this.word = word;
            try {
                Thread.sleep(5);
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
        BufferedReader br = new BufferedReader(new InputStreamReader(CacheTest.class
                .getResourceAsStream("/edu/fabzdev/others/quijote.txt")));
        String line = br.readLine();
        
        Cache cache = new Cache(128);
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()) {
                String word = st.nextToken().trim();
                
                SlowWord sw = cache.getSlowWord(word);
                System.out.println(sw.getWord() + " - cache: " + cache.count);

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
