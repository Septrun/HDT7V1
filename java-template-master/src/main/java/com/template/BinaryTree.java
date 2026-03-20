package com.template;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    private static class Node<E> {
        E data;
        Node<E> left, right;
        Node(E data) { this.data = data; }
    }

    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    private Node<E> insertRecursive(Node<E> current, E value) {
        if (current == null) return new Node<>(value);
        if (value.compareTo(current.data) < 0) 
            current.left = insertRecursive(current.left, value);
        else if (value.compareTo(current.data) > 0)
            current.right = insertRecursive(current.right, value);
        return current;
    }

    public E find(E value) {
        return findRecursive(root, value);
    }

    private E findRecursive(Node<E> current, E value) {
        if (current == null) return null;
        if (value.compareTo(current.data) == 0) return current.data;
        return value.compareTo(current.data) < 0 
            ? findRecursive(current.left, value) 
            : findRecursive(current.right, value);
    }

    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node<E> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }
}