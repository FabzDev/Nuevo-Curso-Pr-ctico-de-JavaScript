package com.fabzdev.generics.dataStructures;

/**
 *
 * @author fabio
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        Node n = new Node();
        n.setName("uno");
        n.setNext(null);

        Node head = n;
        Node tail = head;

        n = new Node();
        n.setName("dos");
        n.setNext(null);
        
        tail.setNext(n);
        tail = n;
        
        n = new Node();
        n.setName("tres");
        n.setNext(null);
        
        tail.setNext(n);
        tail = n;
        
        n=head;
        while(n != null){
            n=n.getNext(); 
        }
    }
}
