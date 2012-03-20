package ru.spbau.korovin.task4.comparable;

/**
 * Comparable String wrap for String type.
 */
public class ComparableString implements Comparable<ComparableString> {
    /**
     * Stored string.
     */
    public final String value;

    /**
     * Constructs C.S. with given value.
     * @param value Stored String value.
     */
    public ComparableString(String value) {
        this.value = value;
    }

    /**
     * Compares object with another. Returns -1 if this < x, 0 if this equal
     * to x and 1 if this > x.
     * @param x Object to compare to.
     * @return One of three values {-1, 0, 1}.
     */
    public int compareTo(ComparableString x) {
        // Don't know, can we use native method or must realize it.
        return Math.round(Math.signum(value.compareTo(x.value)));
    }

    /**
     * Get string representation of comparable string.
     * @return String representation of comparable string.
     */
    public String toString() {
        return value;
    }
}
