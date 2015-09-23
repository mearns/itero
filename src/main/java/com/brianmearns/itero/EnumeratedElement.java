package com.brianmearns.itero;

public class EnumeratedElement<E> {

    private final E value;
    private final long index;

    public EnumeratedElement(long index, E value) {
        this.index = index;
        this.value = value;
    }

    public long getIndex() {
        return index;
    }

    public E getValue() {
        return value;
    }

}

