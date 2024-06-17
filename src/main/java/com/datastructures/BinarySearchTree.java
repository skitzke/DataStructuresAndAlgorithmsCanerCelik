package com.datastructures;

/**
 * A simple generic Binary Search Tree (BST) implementation.
 *
 * @param <E> the type of elements in this tree, which must be Comparable
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    /**
     * Node class representing each element in the BinarySearchTree.
     *
     * @param <E> the type of element stored in the node
     */
    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        /**
         * Constructs a new node with the given data.
         *
         * @param data the data to be stored in this node
         */
        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Constructs an empty BinarySearchTree.
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Inserts the specified element into this tree.
     *
     * @param element the element to be inserted
     */
    public void insert(E element) {
        root = insertRec(root, element);
    }

    /**
     * Recursively inserts an element into the tree.
     *
     * @param root the root node of the tree
     * @param element the element to be inserted
     * @return the new root of the tree
     */
    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) {
            root = new Node<>(element);
            return root;
        }
        if (element.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, element);
        } else if (element.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, element);
        }
        return root;
    }

    /**
     * Searches for the specified element in this tree.
     *
     * @param element the element to be searched
     * @return true if the element is found, false otherwise
     */
    public boolean search(E element) {
        return searchRec(root, element);
    }

    /**
     * Recursively searches for an element in the tree.
     *
     * @param root the root node of the tree
     * @param element the element to be searched
     * @return true if the element is found, false otherwise
     */
    private boolean searchRec(Node<E> root, E element) {
        if (root == null) {
            return false;
        }
        if (element.compareTo(root.data) == 0) {
            return true;
        }
        if (element.compareTo(root.data) < 0) {
            return searchRec(root.left, element);
        } else {
            return searchRec(root.right, element);
        }
    }

    /**
     * Performs an in-order traversal of the tree.
     */
    public void inorder() {
        inorderRec(root);
    }

    /**
     * Recursively performs an in-order traversal of the tree.
     *
     * @param root the root node of the tree
     */
    private void inorderRec(Node<E> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

}
