package ru.spbau.korovin.task4.benchmark;

import ru.spbau.korovin.task4.comparable.Comparable;
import ru.spbau.korovin.task4.comparable.ComparableInteger;
import ru.spbau.korovin.task4.comparator.Comparator;
import ru.spbau.korovin.task4.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Benchmark class, which can measure execution time of different sorters
 * and different comparators.
 */
public class Benchmark {
    /**
     * Measures sorting time of list with given sorter.
     * @param list List to sort.
     * @param sorter Sort algorithm implementation.
     * @return Time of execution in milliseconds, rounded to 3 decimals.
     */
    public static double getTime(List<? extends Comparable> list, Sorter sorter) {
        long start = System.nanoTime();
        sorter.sort(list);
        long finish = System.nanoTime();
        return Math.round((finish - start) * 1e-3) / 1e3;
    }

    /**
     * Measures sorting time of list with given sorter and comparator.
     * @param list List to sort.
     * @param sorter Sort algorithm implementation.
     * @param comparator Comparator used by sorting algorithm.
     * @return Time of execution in milliseconds, rounded to 3 decimals.
     */
    public static double getTime(List<? extends Comparable> list, Sorter sorter,
                                 Comparator comparator) {
        long start = System.nanoTime();
        sorter.sort(list, comparator);
        long finish = System.nanoTime();
        return Math.round(((finish - start) * 1.0e-6) * 1e3) / 1e-3;
    }

    /**
     * Generates list of n random comparable integers.
     * @param n Size of generated list.
     * @return List of n random comparable integers.
     */
    public static List<ComparableInteger> generateList(int n) {
        Random random = new Random(System.nanoTime());
        ArrayList<ComparableInteger> result
                = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ComparableInteger(random.nextInt()));
        }

        return result;
    }
    
}
