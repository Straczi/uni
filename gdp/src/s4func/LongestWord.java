package s4func;

import java.util.Scanner;

public class LongestWord {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println(pickLongest(scanner.nextLine()));
		}
	}
	
	
	static String pickLongest(String text) {
		/*
		int longestWordPos = 0;
		int longestWordLen = -1;
		
		int currentWordLen = 0;
		for (int i = 0; i < text.length(); i++) {
			currentWordLen++;
			
			if (text.charAt(i) == ' ' && longestWordLen < currentWordLen) {
				longestWordPos = i;
				longestWordLen = currentWordLen;
				currentWordLen = 0;
			}
		}	
		*/
		
		String longestWord = "";
		String currentWord = "";
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			if (currentChar != ' ') {
				currentWord += currentChar;
			}
			
			if (currentChar == ' ' || i == text.length() - 1) {
				if (longestWord.length() < currentWord.length()) {
					longestWord = currentWord;
				}
				
				currentWord = "";
			}
		}
		
		return longestWord;
	}
}
