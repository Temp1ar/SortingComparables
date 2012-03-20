package ru.spbau.korovin.task4.comparator;

/**
 * Exception thrown, when it is possible, that will be performed division by
 * zero.
 */
class DivisionByZeroPossibility extends RuntimeException {
    /**
     * Constructs exception with message.
     * @param s Message of exception.
     */
    public DivisionByZeroPossibility(String s) {
        super(s);
    }
}
