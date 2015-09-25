package com.brianmearns.itero;

/**
 * An exception that indicates an iteration had ended. For instance, used by
 * {@link IteroElement#get()} to indicate that the element is not valid, i.e.,
 * the iterator has already ended.
 *
 * <p>
 * This is mostly an antipattern, using an exception as flow control. It may have some legitimate
 * uses in this context, but make sure you know what you're doing. There are also some cases where
 * it may be used not for flow control, such as when you were not expecting an iteration to be over.
 *
 */
public class EndOfIterationException extends Exception {

    public EndOfIterationException() {
        super();
    }

    public EndOfIterationException(String s) {
        super(s);
    }

    public EndOfIterationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public EndOfIterationException(Throwable throwable) {
        super(throwable);
    }
}

