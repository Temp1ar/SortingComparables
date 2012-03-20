package ru.spbau.korovin.task4.comparator;

import ru.spbau.korovin.task4.comparable.Comparable;

/**
 * Comparator class. It's comparing comparable objects (Capt. Obvious).
 * @param <T> Objects type.
 */
public interface Comparator<T extends Comparable> {
    /**
     * Compares two objects x and y.
     * @param x First object to compare.
     * @param y Second object to compare.
     * @return -1 if x less than y; 0 if x equal to y; 1 if x greater than y
     */
    int compare(T x, T y);
}
