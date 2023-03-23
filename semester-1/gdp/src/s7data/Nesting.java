package s7data;

public class Nesting {
	public static void main(String[] args) {
		Matryoshka a = new Matryoshka("A", 5, new Matryoshka("B", 2, null));
		System.out.println(describe(a));
		System.out.println(getTotalWeightR(a));
		System.out.println(getTotalWeightI(a));
	}
	
	public static Matryoshka nest(String name, int weight, Matryoshka matroschka) {
		return new Matryoshka(name, weight, matroschka);
	}
	
	public static Matryoshka unnest(Matryoshka matroschka) {
		return matroschka.nestedMatroschka;
	}
	
	public static String describe(Matryoshka matroschka) {
		String description = null;
		
		if (matroschka == null) {
			description = "";
		} else {
			description = "[" 
							+ matroschka.name 
							+ " " 
							+ describe(matroschka.nestedMatroschka) 
							+ " " 
							+ matroschka.mass
							+ "]";
		}
		
		return description;
	}
	
	public static int getTotalWeightR(Matryoshka matroschka) {
		int totalWeight = 0;
		
		if (matroschka != null) {
			totalWeight += matroschka.mass + getTotalWeightR(matroschka.nestedMatroschka);
		}
		
		return totalWeight;
	}
	
	public static int getTotalWeightI(Matryoshka matroschka) {
		int totalWeight = 0;
		Matryoshka next = matroschka;
		
		while(next != null) {
			totalWeight += next.mass;
			next = next.nestedMatroschka;
		}
		
		return totalWeight;
	}
}

class Matryoshka {
	String name;
	int mass;
	Matryoshka nestedMatroschka;
	
	public Matryoshka(String name, int mass, Matryoshka nestedMatroschka) {
		this.name = name;
		this.mass = mass;
		this.nestedMatroschka = nestedMatroschka;
	}
}
