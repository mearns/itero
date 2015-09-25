package com.brianmearns.itero;

import javax.validation.constraints.NotNull;
import java.util.Iterator;

/**
 * An {@link Iteroable} is an object which is associated with a collection of elements over which can be iterated.
 *
 * An {@code Iteroable} is to an {@link Itero} as an {@link Iterable} is to an {@link java.util.Iterator}
 * in the java standard library.
 *
 * @param <E> The type of the elements in this object.
 */
public interface Iteroable<E> extends Iterable<E> {

    /**
     * The defining method of this interface, it returns an {@link Itero} which iterates over
     * the elements of this object.
     *
     * @return An {@link Itero} over this object's elements.
     */
    @NotNull
    Itero<E> iter();

    @Override
    @NotNull
    Iterator<E> iterator();
}

