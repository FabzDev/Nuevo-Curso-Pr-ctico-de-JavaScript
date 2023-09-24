package com.fabzdev.generics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    //UnboundedWildcards
    public static int unboundedWildcard(List<?> lista) { // declaración con tipo wildcard
//    public static int unboundedWildcard(List<Object> lista){ // declaración con tipo Object
        int count = 0;
        if (lista == null) {
            return count++;
        }
        for (Object o : lista) {
            if (o == null) {
                count++;
            }
        }
        return count;
    }

    public static void unboundedWildcardTest() {
        List<String> listaString = new LinkedList();
        unboundedWildcard(listaString); // Error sin uso de wildcard en la declaración del método
    }

    // Captura de comodines
    public static Set<?> listToSet(List<?> src) {
        Set<?> set = new HashSet<>();
        //        set.addAll(src); // Error 
        set = helpListToSet(src); // Lo que hacemos aqui es decir que List y Set tienen el mismo tipo.
        return set;
    }

    public static <T> Set<T> helpListToSet(List<T> srcList) {
        Set<T> set = new HashSet<>();
        set.addAll(srcList);
        return set;
    }

    // Captura de comodines P2
    public static MutableObject copyMutable(MutableObject<? extends Number> m1, MutableObject<? extends Number> m2) {
//        m2.setValue(m1.getValue()); //Error
//        Number n = m1.getValue();
//        m2.setValue(n); //Error
        return m2;
    }

    //Main
    public static void main(String[] args) {
        upperBoundedProcessTest(); //UpperBoundedWildcards
    }
}
