package com.DSALGO;

public class BinarySearchTree {
    Node root;
    static class Node {
        int data;
        Node left,right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    BinarySearchTree() {
        root = null;
    }

    public void search(int data) {
        Node r = searchRoot(root,data);
        if(r == null) {
            System.out.println("Root is not exist at tree");
        }
        else if(r.data == data) {
            System.out.println("Root is exist at tree ");
        }
    }

    public Node searchRoot(Node root, int data) {
        if(root == null || root.data == data) {
            return root;
        }

        if(root.data < data) {
            return searchRoot(root.right, data);
        }
        return searchRoot(root.left, data);
    }

    void insertRoot(int data) {
        root = insertRec(root,data);
    }
    public Node insertRec(Node root, int data) {
        if(root == null || root.data == data) {
            root = new Node(data);
            return root;
        }

        if(root.data < data) {
            root.right = insertRec(root.right,data);
        }

        if(root.data > data) {
            root.left = insertRec(root.left, data);
        }

        return root;
    }

    public void inOrder(){
        inOrderRec(root);
    }
    public void inOrderRec(Node root) {
        if(root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertRoot(50);
        tree.insertRoot(30);
        tree.insertRoot(20);
        tree.insertRoot(40);
        tree.insertRoot(70);
        tree.insertRoot(60);
        tree.insertRoot(80);
        tree.inOrder();
        tree.search(46);
    }
}
