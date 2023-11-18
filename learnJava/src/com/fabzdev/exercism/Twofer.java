/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class Twofer {
    public String twofer(String name) {
        if(name == null){
            return "One for you, one for me.";
        } else {
            return "One for "+name+", one for me.";
        }
    }

    public static void main(String[] args){
        Twofer tf = new Twofer();
        System.out.println(tf.twofer("Alice"));
        System.out.println(tf.twofer("Bohdan"));
        System.out.println(tf.twofer(null));
        System.out.println(tf.twofer("Zaphod"));
        
    }
}
