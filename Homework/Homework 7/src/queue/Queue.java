// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Linked List Queue
// Resources used: https://www.w3schools.com/java/ref_keyword_throws.asp

package queue;

import list.LinkedList;

/**
 * A Linked-List based Queue
 * 
 * @param <T>
 */
public class Queue<T> implements IQueue<T> {
	private LinkedList<T> list;

	/**
	 * Constructor: Initialize the inner list
	 */
	public Queue() {
		list = new LinkedList<>();
		/* TODO: Implement this method */
	}

	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() {
		/* TODO: Implement this method */
		return list.size();
	}

	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		/* TODO: Implement this method */
		/* Hint: Which method in LinkedList.java already accomplishes this? */
		list.insertAtTail(data);
	}

	/**
	 * Simply remove data from the head of the list, throw exception if list is
	 * empty.
	 */
	public T dequeue() throws EmptyQueueException {
		if (list.size() == 0) {
			throw new EmptyQueueException("ERROR: THE LIST IS EMPTY!");
		} else
			return list.removeAtHead();
		/* TODO: Implement this method */
		/* Hint: Which method in LinkedList.java already accomplishes this? */
		/* What should you do if the queue is empty? */
	}

	/**
	 * Simply return the value from the head of the list, list should remain
	 * unchanged
	 * throw exception if list is empty.
	 */
	public T peek() throws EmptyQueueException {
		/* TODO: Implement this method */
		/* Hint: Which method in LinkedList.java already accomplishes this? */
		/* What should you do if the queue is empty? */
		if (list.size() == 0) {
			throw new EmptyQueueException("ERROR: THE LIST IS EMPTY!");
		} else
			return list.get(0);
	}
}
