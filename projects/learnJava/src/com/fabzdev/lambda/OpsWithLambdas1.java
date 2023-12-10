/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.lambda;

/**
 *
 * @author fabio
 */
public class OpsWithLambdas1 {

    private interface FilterI<T> {

        public int filter(T data);
    }

    public static void playData(Integer[] data, FilterI<Integer> f) {
        int test = 0;
        for (int d : data) {
            test = d + f.filter(d);
            System.out.println(test);
        }
        System.out.println();
    }


public static void main(String[] args) {
        Integer[] data = {1,2,3,4,5,6,7,8,9,10};
        OpsWithLambdas1.playData(data, (n) -> n + 1);
    }
}
