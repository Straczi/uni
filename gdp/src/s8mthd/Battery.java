package s8mthd;

public class Battery {
	private int capacity;
	private int chargeAmount = 0;
	
	public static void main(String[] args) {
		var bat = new Battery(1000);
		String stars;
		do {
			stars = bat.consume();
			bat.load(1000);
		} while(!stars.equals(""));
	}
	
	public Battery(int initialCapacity) {
		this.capacity = initialCapacity;
	}
	
	public boolean isFull() {
		return ((double)this.chargeAmount / (double)this.capacity) > 0.9;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void load(int mAh) {
		this.chargeAmount += mAh;

		if (this.chargeAmount > this.capacity) {
			this.chargeAmount = this.capacity;
		}
		
		this.capacity -= 1;
	}
	
	public String consume() {
		var sb = new StringBuilder();
		int amountOfStars = this.chargeAmount / 20;
		
		for (int i = 0; i < amountOfStars; i++) {
			sb.append('*');
		}
		
		return sb.toString();
	}
}
