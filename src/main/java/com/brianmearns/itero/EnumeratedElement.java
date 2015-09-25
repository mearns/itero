package com.brianmearns.itero;

/**
 * An {@code EnumeratedElement} encapsulates an element from an iteration and it's numerical index in the iteration.
 *
 * @param <E> The type of the element.
 */
public class EnumeratedElement<E> {

    private final E value;
    private final long index;

    /**
     * @param index The {@link #getIndex() index} of the element.
     * @param value The {@link #getValue() value} of the element.
     */
    public EnumeratedElement(long index, E value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Returns the numerical index of this element in the context of the iteration that produced it. Note that this
     * isn't necessarily 0 indexed, or even 1 indexed. The iteration can choose to start at any arbitrary index.
     */
    public long getIndex() {
        return index;
    }

    /**
     * The actual element value.
     */
    public E getValue() {
        return value;
    }

}

