package edu.fabzdev.dataStructures;

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
    }

    private TreeNode createNode() {

        TreeNode res = new TreeNode("Objeto", new TreeNode("Vivo",
                new TreeNode("Vertebrado", new TreeNode("Caballo", null, null), new TreeNode("Perro", null, null)),
                new TreeNode("Invertebrado", new TreeNode("Gusano", null, null), new TreeNode("Medusa", null, null))),
                new TreeNode("No-Vivo",
                        new TreeNode("Natural", new TreeNode("Roca", null, null), new TreeNode("Lago", null, null)),
                        new TreeNode("Artificial", new TreeNode("Casa", null, null), new TreeNode("Bicicleta", null, null))));
        return res;
    }

    private void recursivePrint(TreeNode tree, int level) {
        if (tree == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            if (i == 0) {
                System.out.print("|");
            } else if (i == level - 1) {
                System.out.print("---- ");
            } else {
                System.out.print("----");

            }
        }
        System.out.println(tree.text);
        recursivePrint(tree.right, level + 1);
        recursivePrint(tree.right, level + 1);
    }

    private void printTree(TreeNode tree) {
        recursivePrint(tree, 0);
    }

    public static void main(String[] args) {
        TreeDemo2 td2 = new TreeDemo2();
        TreeNode root = td2.createNode();
        td2.printTree(root);
        for (int i = 0; i < 1; i++) {
            System.out.println("cero");
        }
    }
}
