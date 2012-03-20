package ru.spbau.korovin.task4.sorter;

import ru.spbau.korovin.task4.comparable.Comparable;
import ru.spbau.korovin.task4.comparator.Comparator;

import java.util.List;

/**
 * Sorting algorithm interface.
 */
public interface Sorter {
    /**
     * Sort list with default comparator.
     * @param list List to sort.
     */
    void sort(List<? extends Comparable> list);

    /**
     * Sort list with given comparator.
     * @param list List to sort.
     * @param c Given comparator.
     */
    void sort(List<? extends Comparable> list, Comparator c);
}
