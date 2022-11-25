package s8mthd;


public class IntSet {
	int[] set;
	int size = 0;
	
	public static void main(String[] args) {
		IntSet a = new IntSet(new int[] {1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 4});
		IntSet b = new IntSet(new int[] {4, 5, 6, 7, 8, 9, 10, 10, 9, 9, 7, 7, 7, 5, 4, 5});
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(a.intersect(b));
		System.out.println(a.difference(b));
		System.out.println(a.union(b));
		
		System.out.println(a.size());
		System.out.println(b.size());
		System.out.println(a.intersect(b).size());
		System.out.println(a.difference(b).size());
		System.out.println(a.union(b).size());
	}
	
	public IntSet(int[] initialNumbers) {
		this.set = new int[initialNumbers.length];
		for(int number : initialNumbers) {
			this.addNumber(number);
		}
	}
	
	public IntSet intersect(IntSet other) {
		IntSet intersection = new IntSet(new int[other.set.length]);
		
		for (int number : other.set) {
			if (this.contains(number)) {
				intersection.addNumber(number);
			}
		}
		
		return intersection;
	}
	
	public IntSet difference(IntSet other) {
		IntSet difference = new IntSet(new int[other.set.length]);
		
		for(int number : this.set) {
			if (!other.contains(number)) {
				difference.addNumber(number);
			}
		}
		
		return difference;
	}
	
	public IntSet union(IntSet other) {
		IntSet union = new IntSet(new int[this.size + other.size]);		
		
		for(int number : this.set) {
			union.addNumber(number);
		}
		for(int number : other.set) {
			union.addNumber(number);
		}
		
		return union;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		var sb = new StringBuilder();
		sb.append('{');
		
		for (int i = 0; i < this.size; i++) {
			sb.append(this.set[i]);
			if (i < (this.size - 1)) {
				sb.append(',');
			}
		}
		
		sb.append('}');
		
		return sb.toString();
	}

	
	
	private boolean contains(int number) {
		for(int i : this.set) {
			if (i == number) {
				return true;
			}
		}
		
		return false;
	}
	
	private void addNumber(int number) {
		if (this.capacity() == 0) {
			growSet();
		}
		
		if (!this.contains(number)) {
			set[this.size] = number;
			this.size++;
		}	
	}
	
	private void growSet() {	
		int[] oldSet = this.set;
		int[] newSet = new int[this.set.length * 2];
		
		for (int i = 0; i < oldSet.length; i++) {
			newSet[i] = oldSet[i];
		}
		
		this.set = newSet;
	}
	
	private int capacity() {
		return this.set.length - size;
	}
}