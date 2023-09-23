package com.fabzdev.generics;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fabio
 */ 
public class DestType {

    public static <T> List<T> loadData() {
        return new LinkedList<>();
    }

    public static void toLower(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toLowerCase());
        }
    }

    public static void main(String[] args) {
//        List<String> list = DestType.<String>loadData();
        toLower(loadData());
    }
}
