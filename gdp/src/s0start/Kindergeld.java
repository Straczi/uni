package s0start;

import java.util.Scanner;

public class Kindergeld {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
	
		int anzahl = scanner.nextInt();
		
		int anspruch = 0;
		
		if (anzahl > 3) {
			anspruch += (anzahl - 3) * 250;
			anzahl = 3;
		}
		
		if (anzahl > 2) {
			anspruch += 225;
			anzahl--;
		}
		
		anspruch += anzahl * 219;
		
		System.out.println("Anspruch = " + anspruch);
	}
}
