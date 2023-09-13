package com.fabzdev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Set set = new HashSet();
        set.add("uno");
        set.add("dos");
        set.add("tres");
        set.add("cuatro");
        set.add("cinco");
        set.add("seis");

        for (Iterator it = set.iterator(); it.hasNext();) {
            String s = (String) it.next();
            System.out.println(s);
        }

    }

    private static void linkedHashSetTest() {
        Set set = new LinkedHashSet();
        set.add("uno");
        set.add("dos");
        set.add("tres");
        set.add("cuatro");
        set.add("cinco");
        set.add("seis");

        for (Iterator it = set.iterator(); it.hasNext();) {
            String s = (String) it.next();
            System.out.println(s);
        }

    }

    private static void treeSetTest() {
        Set set = new TreeSet();
        set.add("uno");
        set.add("dos");
        set.add("tres");
        set.add("cuatro");
        set.add("cinco");
        set.add("seis");

        for (Iterator it = set.iterator(); it.hasNext();) {
            String s = (String) it.next();
            System.out.println(s);
        }

    }

    private static void mapTest() {
        Map map = new HashMap();
        map.put("uno", 1);
        map.put("dos", 2);
        map.put("tres", 3);
        map.put("cuatro", 4);
        map.put("cinco", 5);

        for (Iterator it = map.keySet().iterator(); it.hasNext();) {
            String n = (String) it.next();
            System.out.println(n);
        }

        System.out.println();

        for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry n = (Map.Entry) it.next();
            System.out.println("Llave: " + n.getKey() + ", Valor: " + n.getValue());
        }

        System.out.println();

        for (Iterator it = map.keySet().iterator(); it.hasNext();) {
            System.out.println(map.get(it.next()));
        }

    }

    private static void linkedHashMapTest() {
        Map map = new LinkedHashMap();
        map.put("uno", 1);
        map.put("dos", 2);
        map.put("tres", 3);
        map.put("cuatro", 4);
        map.put("cinco", 5);

        for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry n = (Map.Entry) it.next();
            System.out.println(n);
        }
    }
    
    private static void treeMapTest() {
        Map map = new TreeMap();
        map.put("uno", 1);
        map.put("dos", 2);
        map.put("tres", 3);
        map.put("cuatro", 4);
        map.put("cinco", 5);

        for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry n = (Map.Entry) it.next();
            System.out.println(n);
        }
    }
    
    private static void propertiesTest() {
        Properties p = new Properties();
        p.setProperty("Mushoku", "Tensei");
        p.setProperty("Rudeus", "Gryrad");
        p.setProperty("Eris", "Boras Gryrat");
        p.setProperty("Silphyeth", "Fitz");
        
        try(OutputStream o = new FileOutputStream("C:/TheJavaPathV2/prop.p")){
        p.store(o, "El mundo de Mushoku Tensei");            
        } catch (IOException ex) {
            System.out.println("Error de escritura: " + ex);
        }
        
        try(InputStream o = new FileInputStream("C:/TheJavaPathV2/prop.p")){
        p.load(o);
        } catch (IOException ex) {
            System.out.println("Error de Lectura: " + ex);
        }
        
    }
    
     private static void propertiesTest2() {
        Properties p = new Properties();
        
        try(InputStream in = new FileInputStream("C:/TheJavaPathV2/prop.p")){
        p.load(in);
            System.out.println(p.get("Eris"));    
        
        } catch (IOException ex) {
            System.out.println("Error de Lectura: " + ex);
        }
        
    }

    public static void main(String[] args) {
//        testSet();
//        equalsTest();
//        iteratorTest();
//        linkedHashSetTest();
//        treeSetTest();
//        mapTest();
//        linkedHashMapTest();
//        treeMapTest();
//        propertiesTest();
//        propertiesTest2();

    }
}
