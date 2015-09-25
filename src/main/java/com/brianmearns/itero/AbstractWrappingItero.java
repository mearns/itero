package com.brianmearns.itero;

import javax.validation.constraints.NotNull;

/**
 * An {@link Itero} that wraps another {@link Itero} and delegates to it for at least some of its functionality.
 *
 * <p>
 *     By extending {@link AbstractItero}, you only need to override {@link #hasNext()} and {@link #next()} to
 *     change the iteration behavior (by default these methods are implemented in this class to simply delegate to
 *     the provided {@link #source} {@link Itero}). All other interface methods depend entirely on those for their
 *     behavior.
 * </p>
 */
public abstract class AbstractWrappingItero<E> extends AbstractItero<E> {

    @NotNull
    private final Itero<E> source;

    protected AbstractWrappingItero(@NotNull Itero<E> source) {
        this.source = source;
    }

    protected Itero<E> getSource() {
        return source;
    }

    @Override
    public boolean hasNext() {
        return source.hasNext();
    }

    @Override
    public E next() {
        return source.next();
    }
}
