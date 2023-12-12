package edu.fabzdev.dataStructures;

public class DoubleLinkedList {

    public DNode head;

    public void addNode(String name) {
        DNode dnode = new DNode();
        dnode.name = name;

        if (head == null) {
            head = dnode;
        } else {
            DNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = dnode;
            dnode.prev = temp;
        }
    }

    public void replace(String name, String name2) {
        DNode node = new DNode();
        node.name = name2;

        if (head == null) //Condición de seguridad si la lista esta vacia
        {
            return;
        }
        DNode temp = head;
        while (temp.next!= null && !temp.name.equals(name)) {
            temp = temp.next;
        }

        if (temp.equals(head)) {
            node.next = head.next;
            head.next.prev = node;
            head = node;
        } else if (temp.next != null) {
            node.prev = temp.prev;
            node.next = temp.next;
            temp.prev.next = node;
            temp.next.prev = node;
        } else if (temp.name.equals(name)) {
            temp = temp.prev;
            temp.next = node;
            node.prev = temp;
        } else {
            return;
        }

    }

    public void remove(String name) {
        if (head == null) //Condición de seguridad si la lista esta vacia
        {
            return;
        }
        DNode temp = head;
        while (temp.next!= null && !temp.name.equals(name)) {
            temp = temp.next;
        }

        if (temp.equals(head)) {
            head.next.prev = null;
            head = head.next;
        } else if (temp.next != null) {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        } else if (temp.name.equals(name)) {
            temp.prev.next = null;
        } else {
            return;
        }

    }
    
    public void printNodes(){
        DNode temp = head;
        while (temp != null) {
            System.out.println(temp.name);
            temp = temp.next;
        }
    }

}
