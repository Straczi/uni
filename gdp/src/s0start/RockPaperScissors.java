package s0start;

import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		char a_choice = scanner.next().toLowerCase().charAt(0);
		char b_choice = scanner.next().toLowerCase().charAt(0);
		
		if (schummelt(a_choice) && schummelt(b_choice)) {
			System.out.println("Beide schummeln");
			return;
		} else if (schummelt(a_choice)) {
			System.out.println("A schummelt");
			return;
		} else if (schummelt(b_choice)) {
			System.out.println("B schummelt");
			return;
		}
		
		if (a_choice == b_choice) {
			System.out.println("Unentschieden");
			return;
		}
		
		if ((a_choice == 'r' && b_choice == 's')
				|| (a_choice == 'p' && b_choice == 'r')
				|| (a_choice == 's' && b_choice == 'p')
			) {
			System.out.println("A gewinnt");
		} else {
			System.out.println("B gewinnt");
		}
	}
	
	static boolean schummelt(char choice) {
		return choice != 'r' && choice != 'p' && choice != 's';
	}
}
