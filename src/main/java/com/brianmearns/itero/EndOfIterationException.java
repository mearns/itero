package com.brianmearns.itero;

/**
 * An exception that indicates an iteration had ended. For instance, used by
 * {@link IteroElement#get()} to indicate that the element is not valid, i.e.,
 * the iterator has already ended.
 */
public class EndOfIterationException extends Exception {

    private static final EndOfIterationException instance = new EndOfIterationException();

    public static EndOfIterationException instance() {
        return instance;
    }

    private EndOfIterationException() {
        super();
    }

}

