package testat;

import java.util.Scanner;

public class SimpleStat {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		int maximum = Integer.MIN_VALUE;
		int minimum = Integer.MAX_VALUE;
		double avg = 0;
		int count = 0;
		boolean allsame = true;
		boolean increasing = true;

		int nextNumber = scanner.nextInt();
		int lastNumber = nextNumber;
		
		while(nextNumber != 0) {
			avg += nextNumber;
			
			if (nextNumber < minimum) {
				minimum = nextNumber;
			}
			
			if (nextNumber > maximum) {
				maximum = nextNumber;
			}
			
			if (count != 0 && !(allsame && lastNumber == nextNumber)) {
				allsame = false;
			}
			
			if (count != 0 && !(increasing && lastNumber < nextNumber)) {
				increasing = false;
			}
			
			lastNumber = nextNumber;
			nextNumber = scanner.nextInt();
			count++;
		}
		avg = avg / count;
		
		System.out.println("min = " + minimum);
		System.out.println("max = " + maximum);
		System.out.println("avg = " + avg);
		
		if (allsame) {
			System.out.println("allsame");
		}
		
		if (increasing) {
			System.out.println("increasing");
		}
		
	}
}
