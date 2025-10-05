// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Vectors
// Resources used: https://www.w3schools.com/java/java_ref_arrays.asp
package vector;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class Vector<T> implements SimpleList<T> {

	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;

	public Vector() {
		this(INITIAL_CAPACITY); // calls the other constructor that takes an int parameter
	}

	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}

	public int capacity() {
		return this.itemArray.length;
	}

	/**
	 * When the underlying array fills up, we need to somehow resize it to
	 * accommodate the
	 * Vectors's elements.
	 * Ignores the request if the requested new capacity is too small to fit the
	 * elements
	 * already in the Vector
	 */
	public void resize(int newCapacity) {

		if (newCapacity > size) {
			itemArray = Arrays.copyOf(itemArray, newCapacity);
			// itemArray = itemArrayTemp;
		}
		// System.out.println("new item array length: " + itemArray.length);
		// TODO: Implement this method
	}

	@Override
	public int size() { // check!
		// int counter = 0;
		// for (int i = 0; i < itemArray.length; i++) {
		// if (itemArray[i] != null) {
		// counter++;
		// } else
		// return counter;
		// }
		return size;
		// TODO: Implement this method
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			itemArray[i] = null;
		}
		size = 0;
		// TODO: Implement this method
	}

	@Override
	public void insertAtTail(T item) {
		// this.size++;
		// final int temp = this.size;
		// System.out.println("YOUR SIZE IS: " + size);
		if (size >= capacity()) {
			// System.exit(0);
			resize(size + 1);
		}
		if (size == 0) { // if there's nothing in the array
			// System.out.println("size is zero you buffoon");
			// this.resize(1);
			size++;
			itemArray[0] = item;

		} else if (size >= 1) {
			// System.out.println("Got in here");

			// this.resize(this.size + 1);
			// System.out.println("first value: " + itemArray[0]);
			// System.out.println("second value: " + itemArray[1]);
			// System.out.println("the size is: " + size);
			// if (this.size - 1 == 0) {
			// System.out.println("STOP!");
			// System.exit(0);
			// }
			// System.out.println("the size is now: " + size);
			this.size++;
			// System.out.println("the item that should be here: " + item);
			// System.out.println("what's actually there: " + itemArray[this.size - 1]);
			// System.out.println("this.size-1 is currently: " + (this.size - 1));
			itemArray[this.size - 1] = item;
			// itemArray[this.size] = item; // this changes when the bottom size changes
			// System.out.println("what's there after: " + itemArray[this.size - 1]);

			// System.out.println(itemArray[0] + ", " + itemArray[1] + ", " + itemArray[2]);
			// System.out.println("what's actually there: " + itemArray[this.size]);
			// System.exit(0);
		}
		// this.size++; // this part messes up because it causes everything to go
		// backwards by one
		// if (size > 1) {
		// System.out.println("-B-B-B-B-B-B-B-B-B-B-B-B--");

		// // now we have a problem
		// System.out.println("first value: " + itemArray[0]);
		// System.out.println("second value: " + itemArray[1]);
		// }
		// if at max
		// resize
		// else
		// insert at tail

		// TODO: Implement this method
	}

	@Override
	public void insertAtHead(T item) {
		if (size >= capacity()) {
			// System.exit(0);
			resize(capacity() * 2);
		}
		if (size == 0) { // if there's nothing in the array
			// System.out.println("size is zero you buffoon");
			// this.resize(1);
			size++;
			itemArray[0] = item;

		} else if (size >= 1) {
			// if at max
			// resize
			// else
			// move everything to the right
			// insert at head
			this.size++;
			for (int i = size - 2; i >= 0; i--) { // swap every value with the one before it
				T temp2 = itemArray[i];
				itemArray[i] = itemArray[i + 1];
				itemArray[i + 1] = temp2;
			}
			// System.out.println(itemArray[0] + ", what first thing is before");
			itemArray[0] = item;
			// System.out.println(itemArray[0] + ", what next thing is after"); // i think
			// this works
			// TODO: Implement this method
		}
	}

	@Override
	public void insertAt(int index, T item) {
		// T[] temp1 = (T[]) new Object[size + 1];
		if (size >= capacity()) {
			// System.exit(0);
			resize(capacity() * 2);
		}
		if (size == 0) { // if there's nothing in the array
			size++;

			// System.out.println("size: " + size);
			// System.out.println("capacity: " + capacity());
			itemArray[0] = item;
		} else if (size >= 1 && index <= size) { // if there is stuff in the array
			// System.out.println("get in here");
			if (index == 0) { // if inserting at front use head method
				insertAtHead(item);
			} else if (index == size) { // if inserting at end use tail method
				insertAtTail(item);
			} else { // if inserting in the middle

				this.size++;
				for (int i = size - 2; i >= index; i--) { // swap every value with the one before it
					T temp3 = itemArray[i];
					itemArray[i] = itemArray[i + 1];
					itemArray[i + 1] = temp3;
				}
				// System.out.println(itemArray[index] + ", what thing is before");
				itemArray[index] = item;
				// System.out.println(itemArray[index] + ", what thing is after");

			}
		}

		// TODO: Implement this method
	}

	@Override
	public T removeAtTail() {
		T temp = itemArray[size - 1];
		// T[] temp1 = (T[]) new Object[size - 1];
		// for (int i = 0; i < temp1.length; i++) {
		// temp1[i] = itemArray[i];
		// }
		itemArray[size - 1] = null;
		size--;
		// itemArray = temp1;
		// TODO: Implement this method

		return temp;
	}

	@Override
	public T removeAtHead() {
		// System.out.println("capacity: " + capacity());
		T temp = itemArray[0];
		// T[] temp1 = (T[]) new Object[size - 1];
		for (int i = 0; i < size; i++) { // swap every value with the one before it
			T temp2 = itemArray[i];
			itemArray[i] = itemArray[i + 1];
			itemArray[i + 1] = temp2;
		}
		removeAtTail(); // head is now at tail, then remove
		// for (int i = 1; i < temp1.length + 1; i++) { // this loop needs work
		// temp1[i - 1] = itemArray[i];
		// }
		// size--;
		// itemArray = temp1;

		// itemArray[itemArray.leng]
		// System.out.println(temp);
		// TODO: Implement this method
		return temp;
	}

	@Override
	public int find(T item) {
		// System.out.println("What we're looking for: " + item);
		for (int i = 0; i < itemArray.length; i++) {
			// System.out.print(itemArray[i] + ", ");
			if (itemArray[i] == null) {
				// System.out.println("something is null???");
				return -1;
			}
			if (itemArray[i].equals(item)) {
				return i;
			}
		}
		return -1;
		// TODO: Implement this method
	}

	@Override
	public T get(int index) {
		for (int i = 0; i < itemArray.length; i++) {
			if (i == index) {
				return itemArray[i];
			}
		}
		// System.out.println("AAAAAAAAAAAAA");
		return null;
		// TODO: Implement this method
	}

	/*
	 * This toString() method allow you to print a nicely formatted version of your
	 * Vector. E.g.
	 * System.out.println( myVector );
	 * It uses utility methods in the Java Arrays library.
	 */
	@Override
	public String toString() {
		// return Arrays.toString(this.itemArray); // prints entire array from 0 to
		// capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
	}

}
