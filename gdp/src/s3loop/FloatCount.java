package s3loop;

import java.util.Scanner;

public class FloatCount {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		long count = 0;
		
		float a = scanner.nextFloat();
		float b = scanner.nextFloat();
		
		if (a > b) {
			float temp = a;
			a = b;
			b = temp;
		}
		
		while(a < b) {
			count++;
			a = Math.nextUp(a);
		}
		
		System.out.println(count);
	}
}
