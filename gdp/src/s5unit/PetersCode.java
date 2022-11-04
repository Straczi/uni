package s5unit;

public class PetersCode {
	public static void main(String[] args) {
		int j = 0, l = 0; double x = 0;
		// Hinter der schließenden Klammer war ein Semikolon welches den loop body zu einem No-op gemacht hat. 
		 for (; x < 100; ++x,++l) {
			 // j = j++; durch einfach nur j++; ersetzt.
			 // j++ ist post increment. Post increment erhöht die Variable, aber für die Berechnung wird noch der 
			 // alte Wert verwendet. Deshalb wird j zwar um 1 erhöht, aber dann wieder auf 0 gesetzt. (Der
			 // ursprüngliche Wert)
			 j++;
		 }
		 
		 for (x = Math.pow(x, 8); j > 0; --x,++l) {
			 // if Abfrage entfernt, durch die riesigen Werte, die X annimmt, ist die Abfrage false, weil die 
			 // Präzision fehlt
			 --j;
		 }
		 
		 System.out.println(j+" "+l);
	}
}
