/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.exception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author fabio
 */
public class MultiCatch {
    public void salute(){
        System.out.println("Salute world");
    }
    
    public static void main(String[] args) {
        try{
        Class clss = Class.forName("com.fabzdev.exception.MultiCatch");
        Object inst = clss.getConstructor().newInstance();
        Method mthd = clss.getMethod("salute");
        mthd.invoke(inst);
        } catch ( ClassNotFoundException | NoSuchMethodException
                | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e){
            System.out.println(e.getMessage());
        }
    }
}
