package s4func;

import java.util.Scanner;

public class NearestFields {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int distance = scanner.nextInt();
		
		System.out.println(x + ", " + y);
		
		for(int currentDistance = 1; currentDistance <= distance; currentDistance++) {
			for (int currentY = y - currentDistance; currentY <= y + currentDistance; currentY++) {
				for(int currentX = x - currentDistance; currentX <= x + currentDistance; currentX++) {
					// Check if the point we want to print already lies inside the square we already printed
					if (pointInRectangle(x - currentDistance + 1, y + currentDistance - 1, x + currentDistance - 1, y - currentDistance + 1, currentX, currentY)) {
						continue;
					}
					System.out.println(currentX + ", " + currentY);
				}
			}
		}
		
		scanner.close();
	}
	
	static boolean pointInRectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY, int x, int y) {
		return x >= topLeftX && x <= bottomRightX && y <= topLeftY && y >= bottomRightY;
	}
}
