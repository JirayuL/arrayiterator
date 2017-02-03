package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for ArrayIterator to iterate array.
 * 
 * @author Jirayu Laungwilawan
 * @version 2.2.17
 * @param <T> revice typr of array iterator.
 */
public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over. */
	private T[] array;
	/** Point the position of array. */
	private int pointer;

	/**
	 * Initialize a new array iterator with the array to process and set pointer
	 * to zero.
	 * 
	 * @param array
	 *            is the array to iterate over.
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.pointer = 0;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	public T next() {
		if (hasNext()) {
			return array[this.pointer++];
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Return true if the next array has value, skip if it's null and return
	 * false when they have no the next array.
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.pointer; i < this.array.length; i++) {
			if (this.array[i] != null) {
				this.pointer = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove array that pointer point at it. If it is call before next() or
	 * call more than time before next(), it throws IllegalStateException().
	 */
	public void remove() {
		if (this.pointer > 0 && this.array[pointer] != null) {
			array[pointer] = null;
		} else {
			throw new IllegalStateException();
		}
	}

}
