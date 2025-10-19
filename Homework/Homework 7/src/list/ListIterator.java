// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Linked List Queue
// Resources used: None

package list;

public class ListIterator<T> {
	protected ListNode<T> curNode; /* Current node (of type ListNode) */

	/* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) {
		this.curNode = currentNode;
		/* TODO: Implement this method */
	}

	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() {
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy tail node? */
		if ((curNode.getData() == null) && (curNode.prev != null)) { // if it IS at the end, return false
			// System.out.println("AAAAAAAAAA");
			return false;
		}
		return true;// (curNode != null);// && (curNode.prev != null));
	}

	public boolean isPastBeginning() {
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy head node? */
		if ((curNode.getData() == null) && (curNode.next != null)) { // if it IS at the end, return false
			System.out.println("AAAAAAAAAA");
			return false;
		}
		return true;
	}

	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		/* TODO: Implement this method */
		/* Hint: Remember to first validate the position of the Iterator */
		if (!isPastEnd() && !isPastBeginning()) { // if it's not past the end or is it before the beginning
			return curNode.getData();
		}
		return null;
	}

	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() {
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move forward before you do! */
		/* (Otherwise, do not move at all) */
		if (!isPastEnd()) { // if there is something in front of you
			curNode = curNode.next;
		}
	}

	public void moveBackward() {
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move backwards before you do! */
		/* (Otherwise, do not move at all) */
		if (!isPastBeginning()) {
			curNode = curNode.prev;
		}
	}
}
