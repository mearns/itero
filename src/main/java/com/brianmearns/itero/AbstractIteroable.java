package com.brianmearns.itero;

import com.google.common.base.Function;

import javax.validation.constraints.NotNull;
import java.util.Iterator;

/**
 *
 */
public abstract class AbstractIteroable<E> implements Iteroable<E> {

    /**
     * Returns a new {@link IteroIterator} wrapping the {@link Itero} returned by
     * {@link #iter()}.
     */
    @Override
    @NotNull
    public Iterator<E> iterator() {
        return new IteroIterator<>(iter());
    }

    /**
     * <p>
     * Generates a new {@link Itero} which filters the elements of this object
     * with the given callback function.
     * </p>
     *
     * <p>
     * The returned {@link Itero} will iterate over exactly those elements from
     * this object for which the given {@code callback} returns a {@code true},
     * in the same order as this object.
     * </p>
     *
     * @param callback The filter callback function which determines which
     * elements from this iterable are included in the returned {@link Itero}.
     *
     * @return An {@link Itero} over those elements of this iterable which
     * pass the given filter.
     */
    public Itero<E> filter(Function<E, Boolean> callback);

    public <M> Itero<M> map(Function<E, M> callback);

    public <M> Itero<M> flatMap(Function<E, Iteroable<M>> callback);

    public EnumeratedElement<E> enumerate();

    public EnumeratedElement<E> enumerate(long start);

    /**
     * <p>
     * Create a new {@link Itero} over the elements in this object which
     * ends iteration after iterating over an element for which the given
     * callback returns a {@code false} value.
     * </p>
     */
    public Itero<E> terminate(Function<E, Boolean> callback);

    public Itero<E> terminateBefore(Function<E, Boolean> callback);

}
