package s8mthd;

public class CardStacks {
	public static void main(String[] args) {
		var stack = new CardDeck(2);
		var stack2 = new CardDeck(2);
		
		System.out.println("Stacks");
		System.out.println(stack);
		System.out.println(stack2);
		System.out.println();
		
		System.out.println("Get top");
		System.out.println(stack.getTop());
		System.out.println(stack2.getTop());
		System.out.println();
		System.out.println();

		System.out.println("moveTop");
		stack.moveTop(stack2);
		System.out.println("Stacks");
		System.out.println(stack);
		System.out.println(stack2);
		System.out.println();
		
		System.out.println("move all");
		System.out.println();
		System.out.println("Stacks:");
		System.out.println(stack);
		System.out.println(stack2);
		System.out.println();
		
		stack.moveAll(stack2);
		
		System.out.println("Stacks:");
		System.out.println(stack);
		System.out.println(stack2);
		System.out.println();
		
		System.out.println("isEmpty");
		System.out.println(stack.isEmpty());
		System.out.println(stack2.isEmpty());
		System.out.println();
		
		System.out.println("isSingle");
		System.out.println(stack.isSingle());
		System.out.println(stack2.isSingle());
		System.out.println();
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
		if (this.isEmpty()) {
			return null;
		}
		
		return this.cards[this.amountOfCards - 1];
	}
	
	public void moveTop(CardDeck other) {
		if (!this.isEmpty()) {
			other.push(this.pop());
		}
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
		
		if (!this.isEmpty()) {
			top = this.cards[this.amountOfCards - 1];
			this.amountOfCards--;
		}
		
		return top;
	}
	
	@Override
	public String toString() {
		var sb = new StringBuilder();
		sb.append("{ ");
		sb.append(" size: ");
		sb.append(this.amountOfCards);
		sb.append(" ;");
		
		for (int i = 0; i < this.amountOfCards; i++) {
			sb.append(this.cards[i]);
			sb.append(" ; ");
		}
		
		sb.append(" }");
		
		return sb.toString();
	}
}

class Card {
	private int value;

	public Card() {
		this.value = (int) (Math.random() * 8 + 2);
	}

	public Card(int value) {
		this.value = value;
	}

	public int getNum() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return "Card [ " + value + " ]";
	}
}