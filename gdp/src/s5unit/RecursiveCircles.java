package s5unit;

import java.awt.Color;

import std.ui.MiniApp;

public class RecursiveCircles extends MiniApp {
	
	static int circleNumber = 0;
	
	
	
	public static void main(String[] args) {
		drawCircles(100, 100, 50, 50);
	}
	
	static void drawCircles(double x, double y, double radius, double minimumRadius) {
		if (radius < minimumRadius) {
			return;
		}
		
		drawCircle("Kreis nr. " + circleNumber, (int) x, (int) y, (int) radius, Color.black);
		circleNumber++;
		double newRadius = radius / (Math.sqrt(2) + 1);
		drawCircles(x - newRadius, y + newRadius, newRadius, minimumRadius);
		drawCircles(x + newRadius, y + newRadius, newRadius, minimumRadius);
		drawCircles(x - newRadius, y - newRadius, newRadius, minimumRadius);
		drawCircles(x + newRadius, y - newRadius, newRadius, minimumRadius);
	}
	
	static int getNoOfCircles() {
		return circleNumber;
	}
}