/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class ReverseString {
    String reverse(String inputString) {
        String s = "";
        char word[] = inputString.toCharArray();
        for(int i= word.length-1; i>=0;i--){
            s = s + word[i];
        }
        return s;
    }
    
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverse("externocleidomastoideo"));
    }
}
