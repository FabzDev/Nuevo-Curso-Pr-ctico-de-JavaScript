/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class MethodReference3 {
    public interface ListFactory <T>{
        public List<T> get();
    }
    
    public <T> List<T> createList(T arr[], ListFactory lf){
        List<T> result = lf.get();
        for(T value:arr)
            result.add(value);
        return result;
    }
    
    public static void main(String[] args) {
        MethodReference3 mr3 = new MethodReference3();
        String nums[] = {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};
        List<String> lista;
        lista = mr3.createList(nums, ArrayList::new);
        System.out.println(lista.getClass() + ": " + lista);
        lista = mr3.createList(nums, LinkedList::new);
        System.out.println(lista.getClass() + ": " + lista);
    }
    
}
