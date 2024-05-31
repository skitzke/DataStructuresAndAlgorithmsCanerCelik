package com.algorithms;

/**
 * This class provides a static method to perform a binary search on an array of Comparable elements.
 */
public class BinarySearch {

    /**
     * Performs a binary search on the given array for the specified key.
     *
     * @param <E>   the type of elements in the array, which must be Comparable
     * @param array the array to be searched, must be sorted in ascending order
     * @param key   the value to search for
     * @return the index of the key if it is found in the array, otherwise -1
     */
    public static <E extends Comparable<E>> int search(E[] array, E key) {
        int low = 0; // The starting index of the array
        int high = array.length - 1; // The ending index of the array

        while (low <= high) {
            int mid = (low + high) / 2; // The midpoint of the current range

            // Compare the mid element with the key
            if (array[mid].compareTo(key) < 0) {
                // If the mid element is less than the key, search the right half
                low = mid + 1;
            } else if (array[mid].compareTo(key) > 0) {
                // If the mid element is greater than the key, search the left half
                high = mid - 1;
            } else {
                // If the mid element is equal to the key, return the mid index
                return mid;
            }
        }

        // Key was not found in the array
        return -1;
    }
}
