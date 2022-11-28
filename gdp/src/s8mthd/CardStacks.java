package s8mthd;

public class CardStacks {
	public static void main(String[] args) {
		var stack = new CardDeck(5);
		
	}
}

class CardDeck {
	private Card[] cards;
	private int amountOfCards;

	public CardDeck(int amountOfCards) {
		this.amountOfCards = amountOfCards;

		Card[] cards = new Card[amountOfCards];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Card();
		}

		this.cards = cards;
	}

	public Card getTop() {
		Card topCard = null;
		
		if (this.isEmpty()) {
			topCard = this.cards[this.amountOfCards];
		}
		
		return topCard;
	}
	
	public void moveTop(CardDeck other) {
		other.push(this.pop());
	}
	
	public void moveAll(CardDeck other) {
		for (int i = 0; i < this.amountOfCards; i++) {
			other.push(this.cards[i]);
		}
		
		this.amountOfCards = 0;
	}
	
	public boolean isEmpty() {
		return this.amountOfCards == 0;
	}
	
	public boolean isSingle() {
		return this.amountOfCards == 1;
	}

	private void push(Card card) {
		if (card == null) {
			return;
		}
		
		if (this.amountOfCards == this.cards.length) {
			Card[] newCardStack = new Card[this.cards.length * 2];
			for (int i = 0; i < this.cards.length; i++) {
				newCardStack[i] = this.cards[i];
			}
			this.cards = newCardStack;
		}

		this.cards[amountOfCards] = card;
		this.amountOfCards++;
	}

	private Card pop() {		
		Card top = null;
		if (this.amountOfCards > 0) {
			top = this.cards[this.amountOfCards - 1];
			this.amountOfCards--;
		}
		
		return top;
	}
}

class Card {
	int value;

	public Card() {
		this.value = (int) (Math.random() * (10 - 2) + 1);
	}

	public Card(int value) {
		this.value = value;
	}

}