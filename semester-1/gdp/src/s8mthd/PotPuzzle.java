package s8mthd;

import java.awt.Color;

import std.ui.MiniApp;

public class PotPuzzle extends MiniApp {
	private static Pot[] pots;
	
	public static void main(String[] args) {
		pots = new Pot[] {new Pot(50, 3000, 0), new Pot(150, 5000, 0), new Pot(250, 8000, 1000000)};

		drawAllPots();
		
		char key = getRealKey();
		while(key != 'e') {
			if (key <= 57 || key >= 48) {
				Pot first = getPot(key);
				
				key = getRealKey();
				Pot second = getPot(key);
				
				System.out.println("Pouring");
				first.pourInto(second);
				
				drawAllPots();
			}
			
			key = getRealKey();
		}
		
		System.out.println("Ded");
		MiniApp.shutdown();
	}
	
	private static Pot getPot(char potNumber) {
		return pots[((int) potNumber - 48) - 1];
	}
	
	private static void drawAllPots() {
		for (Pot pot : pots) {
			pot.show();
		}
	}
	
	private static char getRealKey() {
		char key = getKey();
		while(key == NO_KEY) {
			key = getKey();
		}
		
		System.out.println("Got " + key);
		
		return key;
	}
}

class Pot extends MiniApp {
	private static final int RECTANGLE_WIDTH = 50;
	private static final Color FILL_COLOR = Color.BLUE;
	
	private int xPos;
	private int max;
	private int current;
	
	public Pot(int xPos, int max, int current) {
		if (current > max) {
			current = max;
		}
		
		this.xPos = xPos;
		this.max = max;
		this.current = current;
	}
	
	public void pourInto(Pot other) {
		if (this != other) {
			int space = other.max - other.current;
			if (space >= this.current) {
				other.current += this.current;
				this.current = 0;
			} else {
				other.current += space;
				this.current -= space;
			}
		}
	}
	
	public int getCurrent() {
		return this.current;
	}
	
	public int getMaximum() {
		return this.max;
	}
	
	public void show() {	
		Color color = Color.BLACK;
		if (this.current == 1000) {
			color = Color.GREEN;
		}
		
		int xPos = this.xPos - (RECTANGLE_WIDTH / 2);
		int height = this.max / RECTANGLE_WIDTH;
		int filledHeight = this.current / RECTANGLE_WIDTH;
		
		drawRectangle("Pot" + xPos, xPos, 200 - height, RECTANGLE_WIDTH, height, color);
		fillRectangle("filled" + xPos, xPos, 200 - filledHeight, RECTANGLE_WIDTH, filledHeight, FILL_COLOR);
	}
}
