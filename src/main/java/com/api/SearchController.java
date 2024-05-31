package com.api;

import com.algorithms.BinarySearch;

/**
 * SearchController class to handle search operations.
 */
public class SearchController {
    /**
     * Performs a binary search on the given array.
     *
     * @param array the array to search
     * @param value the value to search for
     * @return the index of the value in the array, or -1 if not found
     */
    public int binarySearch(Integer[] array, int value) {
        return BinarySearch.search(array, value);
    }
}
