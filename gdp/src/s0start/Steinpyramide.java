package s0start;

import java.util.Scanner;


// Es gibt nur Steine der Länge 1, 2, 3, 4, 6 und 8. 


public class Steinpyramide {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		int p = scanner.nextInt();
		int h = scanner.nextInt();
		
		for (int i = h; i >= 0; i--) {
			int width = (i - 1) * 2 + 1;
			
			while(width > 0) {
				if (width < 8) {
					
				}
			}
		}
	}
	
	int getMaxBrickSize(int b) {
		if (b <= 4) {
			return b;
		} else if (b == 5) {
			return 4;
		} else if (b <= 7) {
			return 6;
		} else if (b >= 8) {
			return 8;
		}
		
		return -1;
	}
}
