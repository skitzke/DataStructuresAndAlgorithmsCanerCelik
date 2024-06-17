package com.gui;

import com.api.SearchController;
import com.api.SortingController;

import javax.swing.*;

/**
 * MainFrame class to create the GUI for the Sorting and Searching Application.
 */
public class MainFrame extends JFrame {
    private final SearchController searchController;
    private final SortingController sortingController;

    /**
     * Constructs the MainFrame and initializes the GUI components.
     */
    public MainFrame() {
        setTitle("Sorting and Searching Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchController = new SearchController();
        sortingController = new SortingController();

        AlgorithmPanel algorithmPanel;
        algorithmPanel = new AlgorithmPanel(searchController, sortingController);
        add(algorithmPanel);
    }

    /**
     * Main method to run the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
