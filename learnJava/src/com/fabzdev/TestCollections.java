
package com.fabzdev;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestCollections {
    
    static class Person {
        int primaryKey;
        String name;
        int age;

        @Override
        public boolean equals(Object o2) {
            Person p2 = (Person) o2;
            if ((primaryKey != 0) && (p2.primaryKey != 0)) {
                return primaryKey == p2.primaryKey;
            }
            if (name.equals(p2.name) && (age == p2.age)) {
                return true;
            }
            return false;
        }
        
    }
    
    private static void testSet() {
        Set s = new HashSet();
        s.add("uno");
        s.add("dos");
        s.add("tres");
        s.add("dos");
        s.add("uno");
        
        System.out.println("s.size() = " + s.size());
    }
    
    private static void equalsTest() {
        Object i1 = new Integer(1);
        Object i2 = new Integer(1);
        
        System.out.println(i1.equals(i2));
        
        String s1 = new String("Hola");
        String s2 = new String("Mundo");
        
        System.out.println(s1.equals(s2));
    }
    
    private static void personTest() {
        Person p1 = new Person();
        p1.primaryKey = 100;
        p1.name = "Raul";
        p1.age = 21;
        
        Person p2 = new Person();
        p2.primaryKey = 0;
        p2.name = "Raul";
        p2.age = 21;
    }
    
    private static void iteratorTest() {
        
    }
    
    
    public static void main(String[] args) {
        // testSet();
        // equalsTest();
        // iteratorTest();
        
    }
}
