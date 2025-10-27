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
		// if ((this.curNode == null) || (this.curNode.getData() == null) &&
		// (this.curNode.prev != null)) { // if it IS at
		// // the end,
		// // return
		// // false
		// // System.out.println("AAAAAAAAAA");
		// return true;
		// }
		return curNode.getData() == null && curNode.next == null;// false;// (this.curNode != null);// &&
																	// (this.curNode.prev !=
		// null));
	}

	public boolean isPastBeginning() {
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy head node? */
		// if ((this.curNode == null) && (this.curNode.getData() == null) &&
		// (this.curNode.next != null)) { // if it IS at
		// // the end,
		// // return
		// // false
		// // System.out.println("AAAAAAAAAA");
		// return true;
		// }
		// return false;
		return curNode.getData() == null && curNode.prev == null;
	}

	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		/* TODO: Implement this method */
		/* Hint: Remember to first validate the position of the Iterator */
		if (!isPastEnd() && !isPastBeginning()) { // if it's not past the end or is it before the beginning
			return this.curNode.getData();
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
		if (this.curNode != null && !isPastEnd()) { // if there is something in front of you
			this.curNode = this.curNode.next;
		}
	}

	public void moveBackward() {
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move backwards before you do! */
		/* (Otherwise, do not move at all) */
		if (this.curNode != null && this.curNode.prev != null && !isPastBeginning()) {
			this.curNode = this.curNode.prev;
		}
	}
}
