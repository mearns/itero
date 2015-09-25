package com.brianmearns.itero;

import java.util.Iterator;

/**
 * An abstract base class that implements some of the extended interface of the {@link Itero}
 * interface. The implemented methods rely on the abstract methods {@link #next()} and {@link #hasNext()}.
 *
 */
public abstract class AbstractItero<E> implements Itero<E> {

    /**
     * Returns a new {@link IteroIterator} wrapping this object.
     */
    @Override
    public Iterator<E> iterator() {
        return new IteroIterator<>(this);
    }

    /**
     * Uses {@link #hasNext()} and to determine whether to return a {@linkplain IteroElement#valid(Object) valid}
     * or {@link IteroElement#invalid() invalid} {@link IteroElement} with the {@link #next()} element value.
     *
     * <p>
     *     Note that {@link #next()} is only invoked if {@link #hasNext()} return {@code true}.
     * </p>
     */
    @Override
    public IteroElement<E> nextElement() {
        if(hasNext()) {
            return IteroElement.valid(next());
        }
        return IteroElement.invalid();
    }

    /**
     * If {@link #hasNext()} returns {@code true}, delegates to {@link #next()}; otherwise throws
     * an {@link EndOfIterationException} exception to indicate that there is not next element.
     *
     * <p>
     *     Note that {@link #next()} is only invoked if {@link #hasNext()} return {@code true}.
     * </p>
     *
     * @throws EndOfIterationException If and only if {@link #hasNext()} returns {@code false}.
     */
    @Override
    public E tryNext() throws EndOfIterationException {
        if(hasNext()) {
            return next();
        }
        throw new EndOfIterationException();
    }
}
