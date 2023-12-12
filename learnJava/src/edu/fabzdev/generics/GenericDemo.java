package edu.fabzdev.generics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GenericDemo {

    public static <T> List<T> setToList(Set<T> set, List<T> list) {
        list.clear();
        for (T setItem : set) {
            list.add(setItem);
        }
        return list;
    }
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Uno");
        set.add("Dos");
        set.add("Tres");
        
        List<String> list = new LinkedList<>();
        
        list = GenericDemo.<String>setToList(set, list);
        
        for(String n : list){
            System.out.println(n);
        }
        
    }
}
