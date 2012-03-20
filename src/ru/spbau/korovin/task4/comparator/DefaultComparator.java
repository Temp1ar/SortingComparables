package ru.spbau.korovin.task4.comparator;

import ru.spbau.korovin.task4.comparable.Comparable;

/**
 * Created by IntelliJ IDEA.
 * User: Temp1ar
 * Date: 20.03.12
 * Time: 22:37
 */

/**
 * Compares two objects with default compareTo method.
 */
public class DefaultComparator implements Comparator {
    /**
     * Compares two objects x and y.
     *
     * @param x First object to compare.
     * @param y Second object to compare.
     * @return -1 if x less than y; 0 if x equal to y; 1 if x greater than y
     */
    @Override
    public int compare(Comparable x, Comparable y) {
        return x.compareTo(y);
    }
}
