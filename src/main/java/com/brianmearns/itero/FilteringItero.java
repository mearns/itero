package com.brianmearns.itero;

import com.google.common.base.Function;

import javax.validation.constraints.NotNull;

/**
 *
 */
public class FilteringItero<E> extends AbstractWrappingItero<E> {

    @NotNull
    private final Function<E, Boolean> filter;

    private E next;
    private boolean hasNext;

    public FilteringItero(@NotNull Function<E, Boolean> filter, @NotNull Itero<E> source) {
        super(source);
        this.filter = filter;
        stageNext();
    }

    protected void stageNext() {
        IteroElement<E> ele = getSource().nextElement();
        if(ele.isValid()) {
            next = ele.getValue();
            hasNext = true;
        } else {
            next = null;
            hasNext = false;
        }
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public E next() {
        E next = this.next;
        stageNext();
        return next;
    }
}
