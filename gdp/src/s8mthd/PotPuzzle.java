package s8mthd;

import java.awt.Color;

import std.ui.MiniApp;

public class PotPuzzle {
	public static void main(String[] args) {
		Pot pot = new Pot(0, 1000, 500);
		pot.show();
	}

}

class Pot extends MiniApp {
	int xPos;
	int max;
	int current;
	
	public Pot(int x, int max, int cur) {
		this.xPos = x;
		this.max = max;
		this.current = cur;
	}
	
	public void pourInto(Pot other) {
		int space = other.max - other.current;
		if (space >= this.current) {
			other.current += this.current;
			this.current = 0;
		} else {
			other.current += space;
			this.current -= space;
		}
	}
	
	public int getCurrent() {
		return this.current;
	}
	
	public int getMaximum() {
		return this.getMaximum();
	}
	
	public void show() {
		Color color = Color.BLACK;
		if (this.current == 1000) {
			color = Color.GREEN;
		} else if (false) {
			
		}
		
		drawRectangle("Pot" + xPos, xPos, 150, 25, 25, Color.PINK);
	}
}
