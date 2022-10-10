package s0start;

import java.util.Scanner;

public class Num2Char {
	public static void main(String[] args) throws IllegalArgumentException {
		var scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();

		char first = (char) ((input % 1_000_000) / 10_000);
		char second = (char) ((input % 10_000) / 100);
		char third = (char) ((input % 100));
		
		System.out.println("decode = " + first + second + third);
	}
}
