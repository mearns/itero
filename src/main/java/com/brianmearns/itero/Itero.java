package com.brianmearns.itero;

import java.util.Iterator;

/**
 * An iterator interface.
 *
 * <p>
 * This is very similar in nature to the java standard {@link Iterator} interface, except
 * that it can more effectively be used with immutable collections because it has no {@link Iterator#remove() remove()}
 * method. So instead of throwing an {@link UnsupportedOperationException} when the method is invoked, you can just
 * not have the method at all.
 *
 * <p>
 * To get the classic standard {@link Iterator} interface, use the {@link #iterator()} method.
 *
 * <p>
 * The {@link Itero} interface also provides some additional useful methods over the {@link Iterator} interface,
 * such as {@link #nextElement()} and {@link #tryNext()}.
 *
 * <p>
 * There are multiple common ways to iterate over an {@link Itero} object. For instance, using the traditional
 * while loop with {@link #hasNext()} and {@link #next()}:
 *
 * <pre>{@code
 *  Itero<E> itero;
 * // .. initialize itero ...
 * while(itero.hasNext()) {
 *     E element = itero.next();
 * }
 * }</pre>
 *
 * <p>
 * Or using a {@code while(true)} loop with {@link #tryNext()}:
 *
 * <pre>{@code
 * Itero<E> itero;
 * // .. initialize itero ...
 * try {
 *     while(true) {
 *         E element = itero.tryNext();
 *     }
 * } catch (EndOfIterationException ignore) {
 *     //Exception used as flow control. This may be an antipattern...
 * }
 * }</pre>
 *
 * <p>
 * Or using a {@code for} loop with {@link #nextElement()} and {@link IteroElement#isValid()}:
 *
 * <pre>{@code
 *  Itero<E> itero;
 * // .. initialize itero ...
 * for(IteroElement<E> next = itero.nextElement(); next.isValid(); next = itero.nextElement()) {
 *     E element = next.getValue();
 * }
 * }</pre>
 *
 * <p>
 * Or, because it implement's the {@link Iterable} interface, you can use it in a java for-each loop:
 *
 * <pre>{@code
 *  Itero<E> itero;
 * // .. initialize itero ...
 * for(E element : itero) {
 *     // ...
 * }
 * }</pre>
 */
public interface Itero<E> extends Iterable<E> {

    /**
     * The {@code Itero} interface does <em>not</em> implement the {@link java.util.Iterator}
     * interface because an {@code Itero} is presumed to be immutable and does not have
     * the {@link java.util.Iterator#remove() remove()} method. However, this method,
     * which implements the {@link Iterable} interface, provides the alternate interface
     * for this same object.
     *
     * <p>
     * When implementing this interface, you can return an {@link IteroIterator} which wraps
     * this object in order to satisfy this interface simply.
     */
    @Override
    Iterator<E> iterator();

    /**
     * @return {@code true} if and only if this iterator has more elements.
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration. If the iteration has ended
     * (as indicated by a {@code false} value returned by {@link #hasNext()}
     * prior to this call), then the return value is <em>unspecified</em>.
     *
     * @return The next element in the iteration, if the iteration has not
     * ended.
     */
    E next();

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
    IteroElement<E> nextElement();

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
    E tryNext() throws EndOfIterationException;

}

