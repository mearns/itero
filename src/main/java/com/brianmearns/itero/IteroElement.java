package com.brianmearns.itero;

/**
 * <p>
 * Represents an element from an iterator (specifically an {@link Itero})
 * <em>and</em> the status of the iterator at the time the element was picked.
 * </p>
 *
 * <p>
 * The value of the iteration element is accessed through the {@link #getValue()}
 * method. The {@link #isValid()} indicates whether or not the iteration had
 * already ended when this element was fetched.
 * </p>
 *
 * <p>
 * There is no public constructor for this class, use the static factory functions
 * {@link #valid(T)} and {@link #invalid()}.
 * </p>
 */
public class IteroElement<E> {

    private final boolean valid;
    private final E value;

    /**
     * Create a new {@link IteroElement} which is {@linkplain #isValid() valid}
     * and has the given element value.
     *
     * @param value The {@linkplain #getValue() value} of the iteration element.
     *
     * @return A new valid {@link IteroElement} with the given value.
     */
    public static <T> IteroElement<T> valid(T value) {
        return new IteroElement(true, value);
    }


    /**
     * Return an {@link IteroElement} which is <em>not</em>
     * {@linkplain #isValid() valid}.
     *
     * @return An invalid {@link IteroElement}.
     */
    public static <T> IteroElement<T> invalid() {
        return new IteroElement(false);
    }

    private IteroElement(boolean valid, E value) {
        this.valid = valid;
        this.value = value;
    }

    /**
     * Indicates whether or not the value of the element is valid, meaning that
     * the iteration has not ended when the element was selected.
     *
     * @return {@code true} if and only if {@link #getValue()} will return a valid
     * element value, meaning iteration had not ended when the element was
     * selected.
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Get the value of the iteration element. If this element is
     * <em>not</em> {@linkplain #isValid() valid}, the returned value is
     * <em>undefined</em>
     *
     * @return The iteration element value.
     *
     * @see #get()
     */
    public E getValue() {
        return value;
    }

    /**
     * Get the value of the iteration element, or throw an exception if this element
     * is <em>not</em> {@linkplain #isValid() valid}.
     *
     * <p>
     * This is an alternate interface to using {@link #getValue()} and {@link #isValid()}:
     * instead of having to check whether or not the element is valid, you can use
     * this method and catch the exception to handle the case where the iteration
     * has ended.
     * </p>
     *
     * @return The iteration element value.
     *
     * @throws EndOfIterationException If the element is <em>not</em> valid.
     */
    public E get() throws EndOfIterationException {
        if(valid) {
            return value;
        }
        throw EndOfIterationException.instance();
    }

}

