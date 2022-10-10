package s0start;

import java.util.Scanner;

public class Kniffel {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		int w1 = scanner.nextInt();
		int w2 = scanner.nextInt();
		int w3 = scanner.nextInt();
		int w4 = scanner.nextInt();
		int w5 = scanner.nextInt();
		
		int summe = w1 + w2 + w3 + w4 + w5;
		
		boolean kniffel = w1 == w2 
				&& w1 == w3 
				&& w1 == w4 
				&& w1 == w5;
		
		boolean pasch = w1 == w2 || w1 == w3 || w1 == w4 || w1 == w5
				|| w2 == w3 || w2 == w4 || w2 == w5
				|| w3 == w4 || w3 == w5
				|| w4 == w5;
		
		boolean gerade = w1 % 2 == 0
				&& w2 % 2 == 0
				&& w3 % 2 == 0
				&& w4 % 2 == 0
				&& w5 % 2 == 0;
		
		boolean ungerade = w1 % 2 == 1
				 && w2 % 2 == 1
				 && w3 % 2 == 1
				 && w4 % 2 == 1
				 && w5 % 2 == 1;
	
		boolean fullHouse = (threeSame(w1, w2, w3) && twoSame(w4, w5) && w1 != w5)
				|| (threeSame(w1, w2, w4) && twoSame(w3, w5) && w1 != w5)
				|| (threeSame(w1, w2, w5) && twoSame(w3, w4) && w1 != w4)
				|| (threeSame(w1, w3, w5) && twoSame(w2, w4) && w1 != w2)
				|| (threeSame(w1, w4, w5) && twoSame(w2, w3) && w1 != w2)
				|| (threeSame(w2, w3, w4) && twoSame(w1, w5) && w2 != w5)
				|| (threeSame(w2, w3, w5) && twoSame(w1, w4) && w2 != w4)
				|| (threeSame(w2, w4, w5) && twoSame(w1, w3) && w2 != w1) 
				|| (threeSame(w3, w4, w5) && twoSame(w1, w2) && w3 != w1)
				|| (threeSame(w3, w4, w1) && twoSame(w2, w3) && w3 != w2)
				|| (threeSame(w3, w4, w2) && twoSame(w1, w5) && w3 != w1)
				|| (threeSame(w4, w5, w1) && twoSame(w3, w4) && w4 != w3)
				|| (threeSame(w4, w5, w2) && twoSame(w1, w3) && w4 != w1)
				|| (threeSame(w4, w5, w3) && twoSame(w1, w2) && w4 != w1);
		
		
		System.out.println("Summe = " + summe);
		System.out.println("Kniffel = " + kniffel);
		System.out.println("Pasch = " + pasch);
		System.out.println("Gerade = " + gerade);
		System.out.println("Ungerade = " + ungerade);
		System.out.println("FullHouse = " + fullHouse);
		
		
	}
	
	static boolean threeSame(int w1, int w2, int w3) {
		return w1 == w2 && w1 == w3;
	}
	
	static boolean twoSame(int w1, int w2) {
		return w1 == w2;
	}
}
