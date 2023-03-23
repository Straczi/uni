package testat3;

import java.util.Arrays;

public class EggPack {
	public static void main(String[] args) {
		Hen h = new Hen();
		EggBox eggBox = produce(10, h);
		//System.out.println(eggBox);
		
		/*
		System.out.println("Adding one egg to full box: " + eggBox.put(h.layEgg()));
		System.out.println("Removing one egg; " + Arrays.toString(eggBox.get(1)));
		System.out.println(eggBox);
		System.out.println("Adding one egg to full box: " + eggBox.put(h.layEgg()));
		*/
		
		var takenOutEggs = eggBox.get(6);
		//System.out.println(Arrays.toString(takenOutEggs));
		//System.out.println("taken out eggs len: " + takenOutEggs.length);
		
		eggBox.shake();
		//System.out.println(eggBox);
		
	}
	
	public static EggBox produce(int n, Hen h) {
		EggBox eggBox = new EggBox(n);
		
		for(int i = 0; i < n; i++) {
			eggBox.put(h.layEgg());
		}
		
		return eggBox;
	}
}

class Egg {
	int weight;
	boolean broken;
	
	public Egg() {
		this.broken = false;
		this.weight = (int) (Math.random() * (70 - 60) + 60);
	}
	
	@Override
	public String toString() {
		return "Egg { weight: " + this.weight + " , broken: " + this.broken + " }"; 
	}
}

class Hen {
	public Egg layEgg() {
		return new Egg();
	}
}

class EggBox {
	private Egg[] eggs;
	private int size;
	
	public EggBox(int capacity) {
		this.eggs = new Egg[capacity];
		this.size = 0;
	}
	
	public boolean put(Egg e) {
		boolean success = false;
		
		if (getCapacity() > 0) {
			this.eggs[size] = e;
			size++;
			success = true;
		}
		
		return success;
	}
	
	public void shake() {
		for(Egg e : this.eggs) {
			double brokenChance = Math.random();
			if(e != null && brokenChance > 0.5) {
				e.broken = true;
			}
		}
	}
	
	public Egg[] get(int n) {
		Egg[] takenOutEggs = new Egg[Math.min(size, n)];
		
		for(int i = 0; i < takenOutEggs.length; i++) {			
			takenOutEggs[i] = popEgg();
		}
		
		return takenOutEggs;
	}
	
	
	private Egg popEgg() {
		Egg popped = null;
		
		for(int i = this.eggs.length - 1; i >= 0; i--) {
			if (this.eggs[i] != null) {
				popped = this.eggs[i];
				this.eggs[i] = null;
				this.size--;
				break;
			}
		}
		
		return popped;
	}
	
	private int getCapacity() {
		return (this.eggs.length - this.size);
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "EggBox { \n";
		s += "  size: " + this.size + "\n";
		
		for(int i = 0; i < this.eggs.length; i++) {
			s += "    " + this.eggs[i];
			s += "\n";
		}
		
		s += "}";
		
		return s;
	}
}
