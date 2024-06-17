package com.gui;

import com.api.SearchController;
import com.api.SortingController;
import com.datastructures.BinarySearchTree;
import com.datastructures.DoubleLinkedList;
import com.datastructures.LinkedList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * AlgorithmPanel class to create a panel for algorithm operations.
 */
public class AlgorithmPanel extends JPanel {
    private final JTextArea inputArea;
    private final JLabel resultLabel;
    private Integer[] array;
    private LinkedList<Integer> linkedList;
    private DoubleLinkedList<Integer> doubleLinkedList;
    private final SearchController searchController;
    private final SortingController sortingController;
    private final BinarySearchTree<Integer> binarySearchTree;
    private boolean useDoubleLinkedList;
    private final DecimalFormat decimalFormat;

    /**
     * Constructs an AlgorithmPanel and initializes the components.
     *
     * @param searchController the controller to handle search operations
     * @param sortingController the controller to handle sorting operations
     */
    public AlgorithmPanel(SearchController searchController, SortingController sortingController) {
        this.searchController = searchController;
        this.sortingController = sortingController;
        this.binarySearchTree = new BinarySearchTree<>();
        this.linkedList = new LinkedList<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
        this.useDoubleLinkedList = false;
        this.decimalFormat = new DecimalFormat("#.##");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        inputArea = new JTextArea(5, 40);
        JButton addButton = new JButton("Add Data");
        JButton bubbleSortButton = new JButton("Bubble Sort");
        JButton quickSortButton = new JButton("Quick Sort");
        JButton binarySearchButton = new JButton("Binary Search");
        JButton treeInsertButton = new JButton("Insert into BST");
        JButton treeSearchButton = new JButton("Search in BST");
        JButton switchListButton = new JButton("Switch to Double LinkedList");
        resultLabel = new JLabel("Results will be displayed here");

        // Add Data Button ActionListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] inputs = inputArea.getText().split(",");
                array = new Integer[inputs.length]; // Initialize array with the appropriate size
                linkedList = new LinkedList<>(); // Reset linked list
                doubleLinkedList = new DoubleLinkedList<>(); // Reset double linked list
                for (int i = 0; i < inputs.length; i++) {
                    int value = Integer.parseInt(inputs[i].trim());
                    if (useDoubleLinkedList) {
                        doubleLinkedList.add(value);
                    } else {
                        linkedList.add(value);
                    }
                    array[i] = value;
                }
                resultLabel.setText("Data added successfully.");
            }
        });

        // Bubble Sort Button ActionListener
        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (array == null || array.length == 0) {
                    resultLabel.setText("Please add data first.");
                    return;
                }
                long startTime = System.nanoTime();
                sortingController.bubbleSort(array);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
                resultLabel.setText("Bubble Sort completed in " + decimalFormat.format(duration) + " ms");
            }
        });

        // Quick Sort Button ActionListener
        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (array == null || array.length == 0) {
                    resultLabel.setText("Please add data first.");
                    return;
                }
                long startTime = System.nanoTime();
                sortingController.quickSort(array);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
                resultLabel.setText("Quick Sort completed in " + decimalFormat.format(duration) + " ms");
            }
        });

        // Binary Search Button ActionListener
        binarySearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (array == null || array.length == 0) {
                    resultLabel.setText("Please add data first.");
                    return;
                }
                String input = JOptionPane.showInputDialog("Enter value to search for:");
                if (input == null || input.isEmpty()) {
                    resultLabel.setText("Search cancelled.");
                    return;
                }
                int value = Integer.parseInt(input);
                long startTime = System.nanoTime();
                int result = searchController.binarySearch(array, value);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
                if (result == -1) {
                    resultLabel.setText("Value not found. Search completed in " + decimalFormat.format(duration) + " ms");
                } else {
                    resultLabel.setText("Value found at index " + result + ". Search completed in " + decimalFormat.format(duration) + " ms");
                }
            }
        });

        // Insert into Binary Search Tree Button ActionListener
        treeInsertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] inputs = inputArea.getText().split(",");
                for (String input : inputs) {
                    int value = Integer.parseInt(input.trim());
                    binarySearchTree.insert(value);
                }
                resultLabel.setText("Values inserted into Binary Search Tree.");
            }
        });

        // Search in Binary Search Tree Button ActionListener
        treeSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter value to search in BST:");
                int value = Integer.parseInt(input);
                long startTime = System.nanoTime();
                boolean found = binarySearchTree.search(value);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
                if (found) {
                    resultLabel.setText("Value found in BST. Search completed in " + decimalFormat.format(duration) + " ms");
                } else {
                    resultLabel.setText("Value not found in BST. Search completed in " + decimalFormat.format(duration) + " ms");
                }
            }
        });

        // Switch List Button ActionListener
        switchListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useDoubleLinkedList = !useDoubleLinkedList;
                if (useDoubleLinkedList) {
                    switchListButton.setText("Switch to LinkedList");
                } else {
                    switchListButton.setText("Switch to Double LinkedList");
                }
                resultLabel.setText(useDoubleLinkedList ? "Using Double LinkedList" : "Using LinkedList");
            }
        });

        add(new JScrollPane(inputArea));
        add(addButton);
        add(bubbleSortButton);
        add(quickSortButton);
        add(binarySearchButton);
        add(treeInsertButton);
        add(treeSearchButton);
        add(switchListButton);
        add(resultLabel);
    }
}
