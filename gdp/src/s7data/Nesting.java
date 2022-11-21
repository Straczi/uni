package s7data;

public class Nesting {
	public static void main(String[] args) {
		Matroschka a = new Matroschka("A", 5, new Matroschka("B", 2, null));
		System.out.println(describe(a));
		System.out.println(getTotalWeightR(a));
		System.out.println(getTotalWeightI(a));
	}
	
	public static Matroschka nest(String name, int weight, Matroschka matroschka) {
		return new Matroschka(name, weight, matroschka);
	}
	
	public static Matroschka unnest(Matroschka matroschka) {
		return matroschka.nestedMatroschka;
	}
	
	public static String describe(Matroschka matroschka) {
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
	
	public static int getTotalWeightR(Matroschka matroschka) {
		int totalWeight = 0;
		
		if (matroschka != null) {
			totalWeight += matroschka.mass + getTotalWeightR(matroschka.nestedMatroschka);
		}
		
		return totalWeight;
	}
	
	public static int getTotalWeightI(Matroschka matroschka) {
		int totalWeight = 0;
		Matroschka next = matroschka;
		
		while(next != null) {
			totalWeight += next.mass;
			next = matroschka.nestedMatroschka;
		}
		
		return totalWeight;
	}
}

class Matroschka {
	String name;
	int mass;
	Matroschka nestedMatroschka;
	
	public Matroschka(String name, int mass, Matroschka nestedMatroschka) {
		this.name = name;
		this.mass = mass;
		this.nestedMatroschka = nestedMatroschka;
	}
}
