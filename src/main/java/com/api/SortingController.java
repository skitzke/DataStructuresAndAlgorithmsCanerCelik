package com.api;

import com.algorithms.BubbleSort;
import com.algorithms.QuickSort;

/**
 * SortingController class to handle sorting operations.
 */
public class SortingController {
    /**
     * Sorts the given array using Bubble Sort.
     *
     * @param array the array to sort
     */
    public void bubbleSort(Integer[] array) {
        BubbleSort.sort(array);
    }

    /**
     * Sorts the given array using Quick Sort.
     *
     * @param array the array to sort
     */
    public void quickSort(Integer[] array) {
        QuickSort.sort(array);
    }
}
