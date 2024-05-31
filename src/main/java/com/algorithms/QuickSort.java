package com.algorithms;

/**
 * This class provides a static method to perform quicksort on an array of Comparable elements.
 */
public class QuickSort {

    /**
     * Sorts the given array in ascending order using the quicksort algorithm.
     *
     * @param <E>   the type of elements in the array, which must be Comparable
     * @param array the array to be sorted
     */
    public static <E extends Comparable<E>> void sort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Recursively sorts the subarrays using the quicksort algorithm.
     *
     * @param <E>   the type of elements in the array, which must be Comparable
     * @param array the array to be sorted
     * @param low   the starting index of the subarray to be sorted
     * @param high  the ending index of the subarray to be sorted
     */
    private static <E extends Comparable<E>> void quickSort(E[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the subarray around a pivot element, placing the pivot element
     * in its correct position and ensuring all elements less than the pivot
     * are to its left and all elements greater are to its right.
     *
     * @param <E>   the type of elements in the array, which must be Comparable
     * @param array the array to be sorted
     * @param low   the starting index of the subarray to be partitioned
     * @param high  the ending index of the subarray to be partitioned
     * @return the index of the pivot element after partitioning
     */
    private static <E extends Comparable<E>> int partition(E[] array, int low, int high) {
        E pivot = array[high]; // Choosing the last element as the pivot
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                // Swap array[i] and array[j]
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i + 1] and array[high] (or pivot)
        E temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the index of the pivot element
    }
}
