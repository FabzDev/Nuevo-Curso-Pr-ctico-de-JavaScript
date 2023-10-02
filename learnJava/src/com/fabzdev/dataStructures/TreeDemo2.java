package com.fabzdev.dataStructures;

/**
 *
 * @author fabio
 */
public class TreeDemo2 {

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
        
        public TreeNode createNode(){
            
            TreeNode res = new TreeNode("Objeto", new TreeNode("Vivo",
                    new TreeNode("Vertebrado", new TreeNode("Caballo", null, null), new TreeNode("Perro", null, null)),
                    new TreeNode("Invertebrado", new TreeNode("Gusano", null, null), new TreeNode("Medusa", null, null))),
                    new TreeNode("No-Vivo",
                            new TreeNode("Natural", new TreeNode("Roca", null, null), new TreeNode("Lago", null, null)),
                            new TreeNode("Artificial", new TreeNode("Casa", null, null), new TreeNode("Bicicleta", null, null))));
            return res;
        }
 
//        public static void main(String[] args) {
//            TreeDemo2 td2 = new TreeDemo2();
//
//            TreeDemo2.TreeNode res = td2.new TreeNode("Objeto", td2.new TreeNode("Vivo",
//                    td2.new TreeNode("Vertebrado", td2.new TreeNode("Caballo", null, null), td2.new TreeNode("Perro", null, null)),
//                    td2.new TreeNode("Invertebrado", td2.new TreeNode("Gusano", null, null), td2.new TreeNode("Medusa", null, null))),
//                    td2.new TreeNode("No-Vivo",
//                            td2.new TreeNode("Natural", td2.new TreeNode("Roca", null, null), td2.new TreeNode("Lago", null, null)),
//                            td2.new TreeNode("Artificial", td2.new TreeNode("Casa", null, null), td2.new TreeNode("Bicicleta", null, null))));
//
//        }
        
        
    }
}
