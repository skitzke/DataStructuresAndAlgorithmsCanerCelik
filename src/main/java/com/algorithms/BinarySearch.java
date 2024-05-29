package com.algorithms;

public class BinarySearch {
    public static <E extends Comparable<E>> int search(E[] array, E key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid].compareTo(key) < 0) {
                low = mid + 1;
            } else if (array[mid].compareTo(key) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1; // Key not found
    }
}
