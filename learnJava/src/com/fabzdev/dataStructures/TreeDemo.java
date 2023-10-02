package com.fabzdev.dataStructures;

/**
 *
 * @author fabio
 */
public class TreeDemo {

    private class TreeNode {

        public String text;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(){};
        
        public TreeNode(String text, TreeNode right, TreeNode left) {
            this.text = text;
            this.right = right;
            this.left = left;
        }
    }
    
    public TreeNode createTreeNode(){
        TreeNode res = new TreeNode();
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
        
        return res;
     
    };
    
    public static void main(String[] args) {
        TreeDemo td = new TreeDemo();
        td.createTreeNode();
    }
    
}
