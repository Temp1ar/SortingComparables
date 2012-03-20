package ru.spbau.korovin.task4.comparator;

import ru.spbau.korovin.task4.comparable.ComparableString;

/**
 * Comparator that compares c. strings by its lengths.
 */
public class StringLengthComparator implements Comparator<ComparableString> {
    /**
     * Compares two objects x and y.
     * @param x First object to compare.
     * @param y Second object to compare.
     * @return -1 if x less than y; 0 if x equal to y; 1 if x greater than y
     */
    public int compare(ComparableString x, ComparableString y) {
        return new Integer(x.value.length()).compareTo(y.value.length());
    }
}
