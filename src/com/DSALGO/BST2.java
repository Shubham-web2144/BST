package com.DSALGO;

public class BST2 {
    Node root;
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    BST2() {
        this.root = null;
    }
//    Search
    public void search(int data) {
        Node r = searchRoot(root, data);
        if(r == null){
            System.out.println("Root not found");
        }
        else {
            System.out.println("Root is found");
        }
    }
    public Node searchRoot(Node root, int data) {
        if(root == null || root.data == data) {
            return root;
        }
        if(root.data > data) {
            return searchRoot(root.left,data);
        }
        return searchRoot(root.right, data);
    }
//    insert Node in BST
    public void insert(int data) {
        root = insertRec(root, data);
    }
    public Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
        }

        if(data > root.data) {
            root.right = insertRec(root.right, data);
        }
        if(data < root.data) {
            root.left = insertRec(root.left, data);
        }
        return root;
    }
//    print all nodes
    public void postOrder() {
        printPostOrder(root);
    }
    public void printPostOrder(Node root) {
        if(root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BST2 bst2 = new BST2();
        bst2.insert(5);
        bst2.insert(4);
        bst2.insert(8);
        bst2.insert(3);
        bst2.insert(9);
        bst2.insert(1);
        bst2.postOrder();
        bst2.search(1);
    }
}
