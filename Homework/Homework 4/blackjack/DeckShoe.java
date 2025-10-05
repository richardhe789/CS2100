// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Blackjack
// Resources used: None

/**
 * A stack of more than one deck of cards used in a casino game
 *
 */
public class DeckShoe {

    // An array of decks of cards that comprise this multi-deck.
    private Deck[] decks;

    // you may need other instance variables here
    private int deckNumber;

    // Constructor: instantiates the number of decks specified and
    // adds them to the list of decks
    public DeckShoe(int numDecks) {
        this.decks = new Deck[numDecks];
        this.deckNumber = numDecks;
        for (int i = 0; i < decks.length; i++) {
            decks[i] = new Deck();
        }
        // nDecks = numDecks;
    }

    // Deals the top card from the stack of decks and returns that Card.
    // You can implement this several ways, as long as it correctly
    // deals a card from one of the decks.
    // Important: if you've dealt the last card in all the decks, you'll want
    // to reshuffle all the decks and start over again
    public Card dealTopCard() { // issue is that it's still getting a rank of something that's nonexistant

        if (decks[deckNumber - 1].cardsLeft() <= 0) {// no cards left in the deck <- like 5th deck is
            // at 4th index
            deckNumber--;
            // if (deckNumber == 1) {
            // System.exit(0);
            // }
            if (deckNumber == 0) { // if its the last deck
                this.restoreDecks();

            }

        }
        return decks[deckNumber - 1].dealTopCard(); // this resets the individual deck itself so it doesn't work
                                                    // properly
        // i.e it always returns SOMETHING even if it's not what we want
        // return null;

    }

    // Reshuffles all of the decks.
    protected void restoreDecks() {
        for (int i = 0; i < decks.length; i++) {
            decks[i].restockDeck();
        }
        deckNumber = decks.length; // set pointer back to top
    }

    public int getdeckNumber() { // my own method for testing
        return deckNumber;
    }

    // returns the number of cards left to be dealt in the entire stack of cards.
    public int cardsLeft() {
        return (deckNumber - 1) * 52 + decks[deckNumber - 1].cardsLeft();

    }

}
