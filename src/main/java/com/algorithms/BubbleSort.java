package com.algorithms;

/**
 * This class provides a static method to perform bubble sort on an array of Comparable elements.
 */
public class BubbleSort {

    /**
     * Sorts the given array in ascending order using the bubble sort algorithm.
     *
     * @param <E>   the type of elements in the array, which must be Comparable
     * @param array the array to be sorted
     */
    public static <E extends Comparable<E>> void sort(E[] array) {
        int n = array.length; // The number of elements in the array
        boolean swapped; // Indicates whether a swap occurred in the inner loop

        // Repeat the process until no swaps are needed
        do {
            swapped = false; // No swaps have occurred yet

            // Iterate through the array, comparing adjacent elements
            for (int i = 1; i < n; i++) {
                // If the previous element is greater than the current element, swap them
                if (array[i - 1].compareTo(array[i]) > 0) {
                    E temp = array[i - 1]; // Temporary variable to hold the value for swapping
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true; // A swap has occurred
                }
            }
            n--; // Decrease n because the last element is now in its correct position
        } while (swapped); // Continue looping if a swap occurred in the last iteration
    }
}
