package ru.spbau.korovin.task4.comparator;
import ru.spbau.korovin.task4.comparable.ComparableInteger;

/**
 * Comparator that compares c. integers by modulus n.
 */
public class IntegerModComparator implements Comparator<ComparableInteger> {
    final private int n;

    /**
     * Constructs the comparator with modulus = n
     * @param n Modulus of comparator.
     */
    public IntegerModComparator(int n) {
        if(n == 0) {
            throw new DivisionByZeroPossibility("Can't create integer module" +
                    " comparator with module 0.");
        }
        this.n = n;
    }

    /**
     * Compares two objects x and y.
     * @param x First object to compare.
     * @param y Second object to compare.
     * @return -1 if x less than y; 0 if x equal to y; 1 if x greater than y
     */
    public int compare(ComparableInteger x, ComparableInteger y) {
        return new ComparableInteger(x.value % n)
                .compareTo(new ComparableInteger(y.value % n));
    }

}
