/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class RaindropConverter {

    String convert(int number) {
        String temp = "";
        if (number % 3 == 0) {
            temp = "Pling";
            if (number % 5 == 0) {
                temp += "Plang";
            }
            if (number % 7 == 0) {
                temp += "Plong";
            }
            return temp;
        } else if (number % 5 == 0) {
            temp += "Plang";
            if (number % 7 == 0) {
                temp += "Plong";
            }
            return temp;

        } else if (number % 7 == 0) {
            return "Plong";
        } else {
            return String.format("%d", number);
        }
    }
    
    public static void main(String[] args) {
        RaindropConverter rc = new RaindropConverter();
        System.out.println(rc.convert(35));
    }
}
