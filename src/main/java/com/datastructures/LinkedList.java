package com.datastructures;

/**
 * A simple generic LinkedList implementation.
 *
 * @param <E> the type of elements in this list
 */
public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Node class representing each element in the LinkedList.
     *
     * @param <E> the type of element stored in the node
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        /**
         * Constructs a new node with the given data.
         *
         * @param data the data to be stored in this node
         */
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructs an empty LinkedList.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added
     */
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Retrieves the element at the specified position in the list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public E get(int index) {
        return getNode(index).data;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retrieves the node at the specified position in the list.
     *
     * @param index the index of the node to return
     * @return the node at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    private Node<E> getNode(int index) {
        try {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
