package com.DSALGO;

public class BST {
    Node root;
    static class Node {
        int data;
        Node left,right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    BST() {
        this.root = null;
    }

    public void search(int data) {
        Node r = searchRoot(root, data);
        if(r == null) {
            System.out.println(data + " is not found");
        }
        else {
            System.out.println(data + " is found");
        }
    }

    public Node searchRoot(Node root, int data){
        if(root == null || root.data == data) {
            return root;
        }

        if(root.data < data) {
            return searchRoot(root.right, data);
        }
        return searchRoot(root.left, data);
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
        }

        if(root.data < data) {
            root.right = insertRec(root.right,data);
        }

        if(root.data > data) {
            root.left = insertRec(root.left, data);
        }
        return root;
    }

    public void preOrder() {
        preOrderPrint(root);
    }
    public void preOrderPrint(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preOrderPrint(root.left);
            preOrderPrint(root.right);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(15);
        bst.insert(20);
        bst.insert(5);
        bst.insert(13);
        bst.insert(2);
        bst.preOrder();
        bst.search(9);
    }
}
