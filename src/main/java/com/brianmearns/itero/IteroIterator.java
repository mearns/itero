package com.brianmearns.itero;

import javax.validation.constraints.NotNull;
import java.util.Iterator;

/**
 * A simple implementation of the {@link Iterator} interface which wraps around and delegates to an
 * {@link Itero} object, and throws an {@link UnsupportedOperationException} in the {@link #remove()} method/
 */
public class IteroIterator<E> implements Iterator<E> {

    @NotNull
    private final Itero<E> itero;

    /**
     * Create a new {@link Iterator} which delegates to the given {@link Itero} object.
     * @param itero The {@link Itero} object to wrap. Must not be null.
     */
    public IteroIterator(@NotNull Itero<E> itero) {
        this.itero = itero;
    }

    /**
     * Implements {@link Iterator#hasNext()} by delegating to {@link Itero#hasNext()} on the wrapped {@code Itero}.
     */
    @Override
    public boolean hasNext() {
        return itero.hasNext();
    }

    /**
     * Implements {@link Iterator#next()} by delegating to {@link Itero#next()} on the wrapped {@code Itero}.
     */
    @Override
    public E next() {
        return itero.next();
    }

    /**
     * Always throws an {@link UnsupportedOperationException} to indicate that removable of elements is not possible
     * through this interface.
     *
     * @throws UnsupportedOperationException Always thrown.
     */
    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Elements cannot be removed through this iterator.");
    }
}
