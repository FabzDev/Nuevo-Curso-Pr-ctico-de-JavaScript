package com.fabzdev.generics.dataStructures;

/**
 *
 * @author fabio
 */
public class TreeDemo {
    public String text;
    public TreeDemo left;
    public TreeDemo right;

    public static void main(String[] args) {
        TreeDemo res = new TreeDemo();
        res.right.text = "Vivo";
        
        res.right.right.text = "Vertebrado";
        
        res.right.right.right.text = "Caballo";
        res.right.right.left.text = "Perro";
        
        res.right.left.text = "Invertebrado";
        
        res.right.left.right.text = "Gusano";
        res.right.left.left.text = "Medusa";
        
        res.left.text = "No-Vivo";
        
        res.left.right.text = "Natural";
        
        res.left.right.right.text = "Roca";
        res.left.right.left.text = "Lago";
        
        res.left.left.text = "Artificial";
        
        res.left.left.right.text = "Casa";
        res.left.left.left.text = "Bicicleta";
        
    }
}
