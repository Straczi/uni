package s0start;

import java.util.Scanner;

public class TentCanvas {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		double b = scanner.nextDouble() * 100;
		double t = scanner.nextDouble() * 100;
		
		double h = b / 2;
		
		double dreieck = 0.5 * b * h;
		
		double c = Math.sqrt(Math.pow(b / 2, 2) + Math.pow(h, 2));
		
		double viereck = t * c;
		double grundfläche = t * b;
		
		double ages = Math.round(2 * dreieck + 2 * viereck + grundfläche);
		
		System.out.println("qcm = " + (int) ages);
	}
}
