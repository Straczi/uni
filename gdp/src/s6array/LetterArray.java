package s6array;

import java.util.Arrays;
import java.util.Scanner;

public class LetterArray {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		int[] charCounts = countLetters(input);

		System.out.println(Arrays.toString(charCounts));

		scanner.close();
	}

	static int[] countLetters(String text) {
		int[] charCounts = new int[26];

		text.toLowerCase()
			.chars()
			.map(i -> (char) i)
			.filter(Character::isAlphabetic)
			.forEach(c -> charCounts[c - 'a']++);

		return charCounts;
	}
}
