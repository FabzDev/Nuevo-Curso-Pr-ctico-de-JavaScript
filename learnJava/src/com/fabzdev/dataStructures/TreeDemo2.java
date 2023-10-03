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

        public TreeNode() {
        }

        ;
        
        public TreeNode(String text, TreeNode right, TreeNode left) {
            this.text = text;
            this.right = right;
            this.left = left;
        }

        public TreeNode createNode() {

            TreeNode res = new TreeNode("Objeto", new TreeNode("Vivo",
                    new TreeNode("Vertebrado", new TreeNode("Caballo", null, null), new TreeNode("Perro", null, null)),
                    new TreeNode("Invertebrado", new TreeNode("Gusano", null, null), new TreeNode("Medusa", null, null))),
                    new TreeNode("No-Vivo",
                            new TreeNode("Natural", new TreeNode("Roca", null, null), new TreeNode("Lago", null, null)),
                            new TreeNode("Artificial", new TreeNode("Casa", null, null), new TreeNode("Bicicleta", null, null))));
            return res;
        }

        public void printTree(TreeNode tree) {
            if (tree == null) {
                return;
            }
            printTree(tree.right);
//            System.out.println(tree.text);
            printTree(tree.left);
            System.out.println(tree.text);
        }

    }

    public static void main(String[] args) {
        TreeDemo2 td2 = new TreeDemo2();
        TreeNode tn = td2.new TreeNode();
        TreeNode result = tn.createNode();
        result.printTree(result);
    }
}
