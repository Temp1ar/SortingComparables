package ru.spbau.korovin.task4.comparable;

/**
 * Comparable Integer wrap for int type.
 */
public class ComparableInteger implements Comparable<ComparableInteger> {
    /**
     * Stored value.
     */
    public final int value;

    /**
     * Constructs C.I. with given value.
     * @param value Stored Integer value.
     */
    public ComparableInteger(int value) {
        this.value = value;
    }

    /**
     * Compares object with another. Returns -1 if this < x, 0 if this equal
     * to x and 1 if this > x.
     * @param x Object to compare to.
     * @return One of three values {-1, 0, 1}.
     */
    public int compareTo(ComparableInteger x) {
        if (value > x.value) {
            return 1;
        } else if(value == x.value) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Get string representation of comparable integer.
     * @return String representation of comparable integer.
     */
    public String toString() {
        return value + "";
    }
}
