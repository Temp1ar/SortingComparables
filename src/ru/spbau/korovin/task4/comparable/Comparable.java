package ru.spbau.korovin.task4.comparable;

/**
 * Interface for comparable types.
 * @param <T> Generic type.
 */
public interface Comparable<T> {
    /**
     * Compares object with another. Returns -1 if this < x, 0 if this equal
     * to x and 1 if this > x.
     * @param x Object to compare to.
     * @return One of three values {-1, 0, 1}.
     */
    int compareTo(T x);
}
