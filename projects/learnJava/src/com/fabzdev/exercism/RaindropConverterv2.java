/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exercism;

/**
 *
 * @author fabio
 */
public class RaindropConverterv2 {

//    String convert(int number) {
//        StringBuilder temp = new StringBuilder();
//        if(number%3 == 0)
//            temp.append("Pling");
//        if(number%5 == 0)
//            temp.append("Plang");
//        if(number%7 == 0)
//            temp.append("Plong");
//        if(number%3 != 0 && number%5 != 0 && number%7 != 0)
//            temp.append(String.valueOf(number));
//        return temp.toString();
//    }
    
      String convert(int number) {
        String temp = "";
        if(number%3 == 0)
            temp = temp.concat("Pling");
        if(number%5 == 0)
            temp = temp.concat("Plang");
        if(number%7 == 0)
            temp = temp.concat("Plong");
        if(number%3 != 0 && number%5 != 0 && number%7 != 0)
            temp = temp.concat(String.valueOf(number));
        return temp;
    }
    
    public static void main(String[] args) {
        RaindropConverterv2 rc = new RaindropConverterv2();
        System.out.println(rc.convert(35));
    }
}
