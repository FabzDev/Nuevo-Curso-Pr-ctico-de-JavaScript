/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.reflection;

import java.lang.reflect.Method;

/**
 *
 * @author fabio
 */
public class MethodList {
    public static void main(String[] args) {
        System.out.println("Metodos de la clase Integer");
        Method listMethods[] = String.class.getMethods();
        for(Method m : listMethods){
            Class typeParam[] = m.getParameterTypes();
            StringBuilder sb = new StringBuilder();
            
            for(Class c : typeParam){
                if(sb.length() > 0)
                    sb.append(", ");
                
                
                if(c.isArray()){
                    sb.append(c.getComponentType()).append("[]");
                } else {
                    sb.append(c.getName());
                }
            }
            System.out.printf("%s(%s)\n", m.getName(), sb.toString());
        }
    }
}
