public class Spiel {
	String name;
	int minAlter;

	Set<Spieler> spieler = new TreeSet<>();

	public Spieler(String name, int minAlter) {
		this.name = name;
		this.minAlter = minAlter;
	}
}

class Spieler {
	String name;
	int alter;

	ArrayList<Spiel> spiele = new ArrayList<>();

	public Spieler(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}
}
