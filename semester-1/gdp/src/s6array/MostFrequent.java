package s6array;

import java.util.Scanner;

public class MostFrequent {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		int amount = scanner.nextInt();
		int[] numbers = new int[amount];
		
		for (int i = 0; i < amount; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		int mostFrequent = mostfreq(numbers);
		System.out.println("Most frequent = " + mostFrequent);
	}
	
	
	/**
	 * Gets the most frequent integer from the input array.
	 * 
	 * 
	 * @param	array	array with numbers in the range 1..10000
	 * @return	the		most frequent integer from the input array
	 */
	public static int mostfreq(int[] array) {
		int[] numbers = new int[10_000];
		
		for(int i : array) {
			numbers[i]++;
		}
		
		int largest = 0;
		int largestNumber = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (largest < numbers[i]) {
				largest = numbers[i];
				largestNumber = i;
			}
		}
		
		
		return largest == 0 ? -1 : largestNumber;
	}
}
