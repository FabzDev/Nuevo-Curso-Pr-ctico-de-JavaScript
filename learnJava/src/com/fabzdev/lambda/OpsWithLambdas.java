/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.lambda;

/**
 *
 * @author fabio
 */
public class OpsWithLambdas {

    private interface FilterI<T> {

        public boolean filter(T data);
    }

    public static void FilterData(int[] data, FilterI<Integer> f) {
        for (int d : data) {
            if(f.filter(d)){
                System.out.print(d + " ");
            }
        }
        System.out.println();
    }


public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,10};
        OpsWithLambdas.FilterData(data, (n) -> n % 2 == 0);
        OpsWithLambdas.FilterData(data, (n) -> n % 2 == 1);
    }
}
