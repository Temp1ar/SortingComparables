package ru.spbau.korovin.task4;

import ru.spbau.korovin.task4.benchmark.Benchmark;
import ru.spbau.korovin.task4.comparable.Comparable;
import ru.spbau.korovin.task4.comparable.*;
import ru.spbau.korovin.task4.comparator.*;
import ru.spbau.korovin.task4.sorter.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The task of this app is to show results of different sorting algorithms,
 * with different comparators. Also we need to benchmark these algorithms and
 * show execution time of sorting 10, 100, 1000, 10000 elements lists.
 */
public class Main {
    /**
     * Entry point.
     * @param args Not used.
     */
    public static void main(String[] args) {
        /**
         * Example of creating comparable objects.
         */
        ComparableString s1 = new ComparableString("abcd");
        ComparableString s2 = new ComparableString("cdef");

        /**
         * Example of creating comparator.
         */
        IntegerModComparator cmpMod = new IntegerModComparator(32);
        StringLengthComparator cmpLen = new StringLengthComparator();
        //System.out.println(cmpLen.compare(s2, s1));

        /**
         * Showing strings comparators in action
         */
        ArrayList<ComparableString> stringsList
                = new ArrayList<>();
        ArrayList<ComparableString> stringListCopy;
        stringsList.add(s2);
        stringsList.add(s1);
        stringsList.add(new ComparableString("abc"));
        stringsList.add(new ComparableString("cdjsq"));
        stringsList.add(new ComparableString("ac"));

        System.out.println("Sorting strings with different sorts and comparators.");
        System.out.println(stringsList);

        // Sorting lexicographically with ShakerSort
        stringListCopy = new ArrayList<>(stringsList);
        System.out.println("Sorting array with ShakerSort with default comparator:");
        new ShakerSort().sort(stringListCopy);
        System.out.println(stringListCopy);

        // Sorting by the lengths with ShakerSort
        stringListCopy = new ArrayList<>(stringsList);
        System.out.println("Sorting array with ShakerSort with string length comparator:");
        new ShakerSort().sort(stringListCopy, cmpLen);
        System.out.println(stringListCopy);

        // Sorting lexicographically with Heapsort
        stringListCopy = new ArrayList<>(stringsList);
        System.out.println("Sorting array with HeapSort with default comparator:");
        new HeapSort().sort(stringListCopy);
        System.out.println(stringListCopy);

        // Sorting by the lengths with Heapsort
        stringListCopy = new ArrayList<>(stringsList);
        System.out.println("Sorting array with HeapSort with string length comparator:");
        new HeapSort().sort(stringListCopy, cmpLen);
        System.out.println(stringListCopy);


        System.out.println();
        /**
         * Creating list of comparable integers.
         */
        ArrayList<ComparableInteger> list = new ArrayList<>();
        list.add(new ComparableInteger(32));
        list.add(new ComparableInteger(64));
        list.add(new ComparableInteger(129));
        list.add(new ComparableInteger(258));
        list.add(new ComparableInteger(0));
        list.add(new ComparableInteger(-127));

        /**
         * Some tests, showing correctness of sorting algorithms.
         */
        System.out.println("Sorting integers with different sorts and comparators.");
        System.out.println(list);

        ArrayList<ComparableInteger> listCopy
                = new ArrayList<>(list);
        System.out.println("Sorting array with ShakerSort without comparator:");
        new ShakerSort().sort(listCopy);
        System.out.println(listCopy);

        listCopy = new ArrayList<>(list);
        System.out.println("Sorting array with ShakerSort with mod 32 comparator:");
        new ShakerSort().sort(listCopy, cmpMod);
        System.out.println(listCopy);

        listCopy = new ArrayList<>(list);
        System.out.println("Sorting array with HeapSort without comparator:");
        new HeapSort().sort(listCopy);
        System.out.println(listCopy);

        listCopy = new ArrayList<>(list);
        System.out.println("Sorting array with HeapSort with mod 32 comparator:");
        new HeapSort().sort(listCopy, cmpMod);
        System.out.println(listCopy);

        System.out.println();
        /**
         * Benchmarking of implemented algorithms.
         */
        benchmarkRandomList(10);
        benchmarkRandomList(100);
        benchmarkRandomList(1000);
        benchmarkRandomList(10000);

    }

    /**
     * Helper function that creates list of n random comparable integers,
     * sort them and outputs the results.
     * @param n Size of list.
     */
    private static void benchmarkRandomList(int n) {
        List<? extends Comparable> bigList = Benchmark.generateList(n);
        System.out.println("Sorting array of "+ n +" comparable integers with ShakerSort:");
        System.out.println(Benchmark.getTime(
                new ArrayList<>(bigList), new ShakerSort()) + " ms");
        System.out.println("Sorting array of "+ n +" comparable integers with HeapSort:");
        System.out.println(Benchmark.getTime(
                new ArrayList<>(bigList), new HeapSort()) + " ms");
    }
}
