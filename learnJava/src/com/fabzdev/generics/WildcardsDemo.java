package com.fabzdev.generics;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class WildcardsDemo {
    
    //UpperBoundedWildcards
    public static void upperBoundedProcess(List<? extends Number> lista) {
        System.out.println("Valido");
    }

    public static void upperBoundedProcessTest() {
        List<Integer> listaInteger = new LinkedList<>();
        upperBoundedProcess(listaInteger);
    }
    
    
    public static int unboundedWildcard(List<Object> lista){
        int count=0;
        if(lista == null)
            return count++;
        for(Object o : lista){
            if(o == null){
                count++;
            }
        }
        return count;
    }
    
    
    
    //Main
    public static void main(String[] args) {
        upperBoundedProcessTest(); //UpperBoundedWildcards
    }
}
