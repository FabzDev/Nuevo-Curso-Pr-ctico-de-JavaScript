/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author fabio
 */
public class FieldTest {
    public String str = null;
    
    public void showStr(){
        System.out.println(str);
    }
    
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        FieldTest fieldTest = new FieldTest();
        Field field = fieldTest.getClass().getField("str");
        field.set(fieldTest, "Hola Mundo");
        
        fieldTest.showStr();
        
    }
}
