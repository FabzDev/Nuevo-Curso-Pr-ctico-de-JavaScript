/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.dataStructures;

/**
 *
 * @author fabio
 */
public class Factorial {
    int res = 1;
    public void calcFactorial(int n){
        if(n<1)
            return;
        calcFactorial(n-1);
        res *= n;
    }
    
    public static void main(String[] args) {
        Factorial fact = new Factorial();
        fact.calcFactorial(5);
        System.out.printf("Factorial = %d\n",fact.res);
    }
}
