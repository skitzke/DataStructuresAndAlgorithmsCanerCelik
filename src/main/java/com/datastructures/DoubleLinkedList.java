package com.datastructures;

/**
 * A simple generic Double LinkedList implementation.
 *
 * @param <E> the type of elements in this list
 */
public class DoubleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Node class representing each element in the DoubleLinkedList.
     *
     * @param <E> the type of element stored in the node
     */
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        /**
         * Constructs a new node with the given data.
         *
         * @param data the data to be stored in this node
         */
        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Constructs an empty DoubleLinkedList.
     */
    public DoubleLinkedList() {
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
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
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
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }
}
