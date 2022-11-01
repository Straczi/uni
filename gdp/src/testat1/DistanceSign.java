package testat1;

import java.util.Iterator;
import java.util.Scanner;

public class DistanceSign {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		double zahl = scanner.nextDouble();
		scanner.nextLine();
		String einheit = scanner.nextLine();
		
		if (zahl < 0) {
			zahl *= -1;
		}
		
		System.out.println();
		
		int millimeter = 0;
		switch (einheit) {
		case "mm":
			millimeter = (int) zahl;
			break;
		case "m":
			millimeter = (int) (zahl * 1000);
			break;
		case "km":
			millimeter = (int) (zahl * 1000 * 1000);
		default:
			System.out.println("Unbekannte Einheit");
			return;
		}
		
		
		System.out.println("lang = " + millimeter + " mm");
		
		int kurz = 0;
		String kurzEinheit = "";
		if (millimeter % 1_000_000 == 0) {
			kurz = millimeter / 1_000_000;
			kurzEinheit = "km";
		} else if(millimeter % 1_000 == 0) {
			kurz = millimeter / 1_000;
			kurzEinheit = "m";
		} else {
			kurz = millimeter;
			kurzEinheit = "mm";
		}
		
		System.out.println("kurz = " + kurz + " " + kurzEinheit);
		
		int stellen = 0;
		int k = kurz;
		while(k != 0) {
			k /= 10;
			stellen++;
		}
		
		switch (kurzEinheit) {
		case "mm":
		case "km":
			stellen += 3;
			break;
		case "m":
			stellen += 2;
		default:
			break;
		}
		
		System.out.println("stellen = " + stellen);
		System.out.println();
		
		
		// Straßenschild bauen
		int mengeSterneObenUnten = stellen + 4;
		String sterneObenUnten = "";
		for (int i = 0; i < mengeSterneObenUnten; i++) {
			sterneObenUnten += '*';
		}
		
		System.out.println(sterneObenUnten);
		System.out.println("* " + kurz + " " + kurzEinheit + " *");
		System.out.println(sterneObenUnten);
		
		for (int i = 0; i < (stellen / 2); i++) {
			String outString = "";
			for (int j = 0; j < ((mengeSterneObenUnten / 2) - 1); j++) {
				outString += ' ';
			}
			outString += '*';
			System.out.println(outString);
		}
		
		
	}
}
