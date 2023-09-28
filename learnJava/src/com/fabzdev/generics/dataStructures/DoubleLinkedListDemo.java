/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.generics.dataStructures;

/**
 *
 * @author fabio
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addNode("uno");
        dll.addNode("dos");
        dll.addNode("tres");
        dll.addNode("cuatro");
        dll.addNode("cinco");

        dll.printNodes();
        System.out.println();

        dll.replace("fabio", "unoV2");
//        dll.printNodes();
//        System.out.println();
        dll.remove("fabio");
//        System.out.println(dll.head.name);
//
//        dll.printNodes();

    }
}
