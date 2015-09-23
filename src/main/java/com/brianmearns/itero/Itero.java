package com.brianmearns.itero;

import java.util.Iterator;
import com.google.common.base.Function;

/**
 * An iterator interface.
 */
public interface Itero<E> extends Iteroable<E> {

    /**
     * This method ensures that the {@link Itero} interface also implements the
     * {@link Iteroable} interface, which should be done by simply returning
     * {@code this} object itself.
     *
     * @return This object, unaltered.
     */
    @Override
    public Itero<E> iter();

    /**
     * The {@code Itero} interface does <em>not</em> implement the {@link java.util.Iterator}
     * interface because an {@code Itero} is presumed to be immutable and does not have
     * the {@link java.util.Iterator#remove() remove()} method. However, this method,
     * which implements the {@link Iterable} interface, provides the alternate interface
     * for this same object.
     */
    @Override
    public Iterator<E> iterator();

    /**
     * @return {@code true} if and only if this iterator has more elements.
     */
    public boolean hasNext();

    /**
     * Returns the next element in the iteration. If the iteration has ended,
     * as indicated by a {@code false} value returned by {@link #hasNext()}
     * prior to this call, then the return value is <em>unspecified</em>.
     *
     * @return The next element in the iteration, if the iteration has not
     * ended.
     */
    public E next();

    /**
     * An alternate interface to {@link #next()} which encapsulates both an
     * element value and the status of the iteration. As long as the iteration
     * hasn't ended yet, the returned element will be
     * {@linkplain IteroElement#isValid() valid} and the {@link IteroElement#getValue()}
     * method will return the value of the next iteration element. If the iteration
     * <em>has</em> ended, the returned element will be <em>not</em> be
     * {@linkplain IteroElement#isValid() valid}.
     *
     * @return An {@link IteroElement} representing the next element in the iteration,
     * or an {@linkplain IteroElement#invalid() invalid} {@code IteroElement} if
     * the iteration has ended.
     */
    public IteroElement<E> nextElement();

    /**
     * Returns the next element in the iteration, or throws an {@link EndOfIterationException}
     * if the iteration has already ended. This is an alternate interface to using
     * {@link #next()} and {@link #hasNext()}, or {@link #nextElement()}.
     *
     * @return The next iteration element, if the iteration has not ended.
     *
     * @throws EndOfIterationException if the iteration has already ended and there
     * is no next element.
     */
    public E tryNext() throws EndOfIterationException;

}

