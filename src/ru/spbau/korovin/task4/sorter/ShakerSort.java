package ru.spbau.korovin.task4.sorter;

import ru.spbau.korovin.task4.comparable.Comparable;
import ru.spbau.korovin.task4.comparator.Comparator;
import ru.spbau.korovin.task4.comparator.DefaultComparator;

import java.util.Collections;
import java.util.List;

/**
 * Shaker sort algorithm implementation.
 */
public class ShakerSort implements Sorter {
    /**
     * Sort list with default comparator.
     *
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
    public void sort(List<? extends Comparable> list, Comparator c) {
        int j;
	int limit = list.size();
	int start = -1;
	while (start < limit) {
	    boolean flipped = false;
	    start++;
	    limit--;
	    for (j = start; j < limit; j++) {
		if (isGreater(list, c, j, j+1)) {
                    Collections.swap(list, j, j + 1);
                    flipped = true;
		}
	    }
	    if (!flipped) {
		return;
	    } else {
                flipped = false;
            }
	    for (j = limit; --j >= start;) {
		if (isGreater(list, c, j, j+1)) {
		    Collections.swap(list, j, j + 1);
		    flipped = true;
		}
	    }
	    if (!flipped) {
		return;
	    }
	}
    }

    private static boolean isGreater(List<? extends Comparable> list,
                                     Comparator<Comparable> c, int i, int j) {
        return c.compare(list.get(i), list.get(j)) == 1;
    }
}
