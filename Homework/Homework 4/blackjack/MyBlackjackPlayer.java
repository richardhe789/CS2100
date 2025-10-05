// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Blackjack
// Resources used: None

/*
 * Define a blackjack player by inheriting from the superclass BlackjackPlayer
 *   and implementing the 3 abstract methods.
 */
public class MyBlackjackPlayer extends BlackjackPlayer {
	Card[] dealer = new Card[0];

	@Override
	public int getBet() {
		if (getChips() > 1200) {
			return 20;
		}
		if (getChips() > 1000) {
			return 15;
		}
		return 10; // always bet 10
	}

	@Override
	public Move getMove() {
		/* Hits until we get a score of 16 or better */
		if (dealer.length == 0) {
			return Move.HIT;
		}
		if (this.handScore() == 11 || this.handScore() == 10) {
			return Move.DOUBLE;
		}

		if (dealer[0].getRank() >= 7)
			if (this.handScore() <= 17)
				return Move.HIT;
			else
				return Move.STAY;
		else if (dealer[0].getRank() <= 6) {
			if (this.handScore() <= 12)
				return Move.HIT;
			else
				return Move.STAY;
		}
		return Move.STAY;
	}

	@Override
	public void handOver(Card[] dealerHand) {
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process. The dealer's hand will be
		 * found in the array of Cards that you pass when the method returns.
		 */
		this.dealer = dealerHand;
		for (int i = 0; i < dealer.length; i++) {
			System.out.println(dealer[i]);
		}

	}

}
