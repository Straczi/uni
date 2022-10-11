package s0start;

import java.util.Scanner;

public class Sqrt {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		double a = scanner.nextDouble();
		
		if (a < 0) {
			System.out.println("sqrt = NaN");
			return;
		}
		
		double x = a / 2;
		double d = Double.MAX_VALUE;
		double z = x;
		
		while (d > 0.000_000_1) {
			x = z;
			z = ((a / x) + x) / 2;
			d = (z - x) * (z - x);
		}
		
		System.out.println("sqrt = " + x);
	}
}
