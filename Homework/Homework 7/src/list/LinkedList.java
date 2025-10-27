// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Linked List Queue
// Resources used: https://www.geeksforgeeks.org/dsa/different-methods-to-initialize-a-linked-list/

package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements SimpleList<T> {

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;

	public LinkedList() {
		head = new ListNode<>(null);
		tail = new ListNode<>(null);
		head.next = tail;

		tail.prev = head;
		// ;
		// head.next = null;
		// tail = null;
		size = 0;
		/* TODO: Implement this method */
	}

	public int size() {
		/* TODO: Implement this method */
		return size;
	}

	/**
	 * Clears out the entire list
	 */
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
		/* TODO: Implement this method */
	}

	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail
	 * node)
	 * 
	 * @param data
	 */
	public void insertAtTail(T data) {
		// System.out.println("INSERTING AT TAIL");
		ListNode<T> temp = new ListNode<>(data);

		temp.prev = tail.prev;
		temp.next = tail;
		tail.prev.next = temp;
		tail.prev = temp;

		size++;
		/* TODO: Implement this method */
	}

	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * 
	 * @param data
	 */
	public void insertAtHead(T data) {
		ListNode<T> temp = new ListNode<>(data);
		// if (head.next == null) // if there's nothing at the head position
		// {

		// head.next = temp; // head -> X
		// temp.prev = head; // head <-> X
		// temp.next = tail; // head <-> X -> tail
		// tail.prev = temp; // head <-> X <-> tail
		// } else
		temp.next = head.next; // X --\
								// head -> after head
		temp.prev = head; // / -- X -- \
		// head--------> after head
		head.next.prev = temp;
		head.next = temp;

		size++;
		/* TODO: Implement this method */
	}

	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * 
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		ListNode<T> temp = new ListNode<>(data);
		ListNode<T> pointer = head;
		if (index >= 0 && index <= size()) {
			for (int i = 0; i < index; i++) {
				pointer = pointer.next; // moves head pointer down
			}
			temp.next = pointer.next;
			temp.prev = pointer; // / -- X -- \
			// // head--------> after head
			pointer.next.prev = temp;
			pointer.next = temp;
			size++;

		}
		/* TODO: Implement this method */
	}

	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		ListNode<T> temp = new ListNode<>(data);
		if (it != null && it.curNode != tail) {

			temp.next = it.curNode.next;
			temp.prev = it.curNode; // / -- X -- \
			// // head--------> after head
			it.curNode.next.prev = temp;
			it.curNode.next = temp;
			this.size++;
		}
		/* TODO: Implement this method */
	}

	public T removeAtTail() {
		T removed = null;
		if (size() > 0) {
			removed = tail.prev.getData();
			tail.prev.prev.next = tail;
			tail.prev = tail.prev.prev;
			size--;
		}
		/* TODO: Implement this method */
		return removed;
	}

	public T removeAtHead() {
		T removed = null;
		if (size() > 0) {
			removed = head.next.getData();
			head.next.next.prev = head;
			head.next = head.next.next;
			size--;
		}
		/* TODO: Implement this method */
		return removed;
	}

	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		// ListNode<T> temp = new ListNode<T>(null);
		if (it == null || it.curNode == head || it.curNode == tail) {
			return null;
		}
		ListNode<T> node = it.curNode;
		T data = node.getData();
		node.prev.next = node.next;
		node.next.prev = node.prev;
		it.curNode = node.next;
		// if (it != null && it.curNode != null && it.curNode != tail) {

		// // temp = it.curNode.prev;
		// // it.curNode.prev.next = it.curNode.next;
		// // it.curNode.next.prev = it.curNode.prev;
		// // it.curNode = it.curNode.next;
		this.size--;
		// }

		/* TODO: Implement this method */
		return data;// temp.getData();
	}

	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not
	 * present
	 * 
	 * @param data
	 * @return
	 */
	public int find(T data) {
		int index = 0;
		while (head.next != null && head.next.getData() != null && !head.next.equals(tail.prev)) { // while
																									// head
																									// pointer
																									// doesn't
																									// hit
																									// tail
			if (head.next.getData().equals(data)) {
				for (int i = 0; i < index; i++) { // reset head
					head = head.prev;
				}
				return index;
			} else {
				head = head.next;
				index++;
			}
		}
		// System.out.println("INDEX: " + index);

		// System.out.println("INDEX IS: " + index);
		/* TODO: Implement this method */
		return -1;
	}

	/**
	 * Returns the data at the given index, null if anything goes wrong (index out
	 * of bounds, empty list, etc.)
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		T removed = null;
		if (index >= 0 && index <= size()) {
			// System.out.println("THIS BROKE");
			for (int i = 0; i < index; i++) {
				head = head.next;
			}
			removed = head.next.getData();
			for (int i = 0; i < index; i++) {
				head = head.prev;
			}
		}
		/* TODO: Implement this method */
		return removed;
	}

	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		int count = 0;

		ListNode<T> curNode = head.next;
		while (curNode != tail) {
			count++;
			toRet += curNode.getData();
			if (count != size)
				toRet += ", ";
			curNode = curNode.next;
		}

		return toRet + "]";
	}

	/* Return iterators at front and end of list */
	public ListIterator<T> front() {

		// return curNode;
		/* TODO: Implement this method */
		return new ListIterator<>(head.next);
		// return null;
	}

	public ListIterator<T> back() {
		/* TODO: Implement this method */
		return new ListIterator<>(tail.prev);
		// return null;
	}

}
