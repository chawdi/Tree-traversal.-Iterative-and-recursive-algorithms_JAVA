package algorithms.tree;

import java.util.Stack;

public class Tree {
   private Node root;

   public Tree() {
       root = null;
   }

   public Node getRoot() {
       return root;
   }

   public void addToTree(int value) {
       Node element = new Node(value);
       Node ptr = root;
       Node tmp_ptr = root;
       if (root == null) {
           root = element;
       } else {
           while (tmp_ptr != null) {
               if (tmp_ptr.getValue() < value) {
                   ptr = tmp_ptr;
                   tmp_ptr = tmp_ptr.left;
               } else {
                   ptr = tmp_ptr;
                   tmp_ptr = tmp_ptr.right;
               }
           }
           if (ptr.getValue() < value) {
               ptr.left = element;
               element.parent = ptr;
           } else {
               ptr.right = element;
               element.parent = ptr;
           }
       }
   }

   public void preOrderRec(Node element) {
       if (element != null) {
           preOrderRec(element.left);
           System.out.print(element.value + " ");
           preOrderRec(element.right);
       }
   }

   public void inOrderRec(Node element) {
       if (element != null) {
           System.out.print(element.value + " ");
           inOrderRec(element.left);
           inOrderRec(element.right);
       }
   }

   public void postOrderRec(Node element) {
       if (element != null) {
           postOrderRec(element.left);
           postOrderRec(element.right);
           System.out.print(element.value + " ");
       }
   }

   public void preOrderIt(Node element) {
       Stack<Node> stack = new Stack<Node>();
       while ((element != null) || (!stack.empty())) {
           if (!stack.empty()) {
               element = stack.pop();
           }
           while (element != null) {
               System.out.print(element.value + " ");
               if (element.right != null) {
                   stack.push(element.right);
               }
               element = element.left;
           }
       }
   }

   public void inOrderIt(Node element) {
       Stack<Node> stack = new Stack<Node>();
       while (element != null || !stack.empty()) {
           if (!stack.empty()) {
               element = stack.pop();
               System.out.print(element.value + " ");
               if (element.right != null) {
                   element = element.right;
               } else {
                   element = null;
               }
           }
           while (element != null) {
               stack.push(element);
               element = element.left;
           }
       }
   }

   public void randomize(Tree tree, int size, int max) {
       int value;
       root = null;
       for (int i = 0; i < size; i++) {
           value = (int) (Math.random() * max);
           tree.addToTree(value);
       }
   }

   class Node {
       int value;
       Node parent;
       Node left;
       Node right;

       Node(int value) {
           this.value = value;
           parent = null;
           left = null;
           right = null;
       }

       int getValue() {
           return value;
       }
   }
}
