package ru.spbau.korovin.task4.sorter;

import ru.spbau.korovin.task4.comparable.Comparable;
import ru.spbau.korovin.task4.comparator.Comparator;
import ru.spbau.korovin.task4.comparator.DefaultComparator;

import java.util.Collections;
import java.util.List;

/**
 * Heap sort algorithm implementation.
 */
public class HeapSort implements Sorter {

    /**
     * Sort list with default comparator.
     * @param list List to sort.
     */
    @Override
    public void sort(List<? extends Comparable> list) {
        sort(list, new DefaultComparator());
    }

    /**
     * Sort list with given comparator.
     * @param list List to sort.
     * @param c Given comparator.
     */
    @Override
    public void sort(List<? extends Comparable> list,
                     Comparator c) {
        buildHeap(list, c);
        int size = list.size();
        for (int i = 0; i < list.size() - 1; i++) {
            Collections.swap(list, 0, --size);
            heapify(list, 0, size, c);
        }
    }

    private static void buildHeap(List<? extends Comparable> list,
                                  Comparator<Comparable> c) {
        for(int i = list.size()/2; i > -1; i-- ) {
            heapify(list, i, list.size(), c);
        }
    }

    private static void heapify(List<? extends Comparable> list,
                                int i, int size, Comparator<Comparable> c) {
        int maxIndex = i;
        int left;
        int right;
        
        if(i == 0) {
            left  = 1;
            right = 2;
        } else {
            left  = 2 * i;
            right = 2 * i + 1;
        }

        maxIndex = greaterIndex(list, size, c, maxIndex, left);
        maxIndex = greaterIndex(list, size, c, maxIndex, right);

        if (i != maxIndex) {
            Collections.swap(list, i, maxIndex);
            heapify(list, maxIndex, size, c);
        }
    }

    private static int greaterIndex(List<? extends Comparable> list, int size,
                                    Comparator<Comparable> c, int maxIndex,
                                    int child) {
        if (child < size) {
            if(c.compare(list.get(child), list.get(maxIndex)) == 1) {
                maxIndex = child;
            }
        }
        return maxIndex;
    }
}
