package s0start;

import java.awt.Color;

import std.ui.MiniApp;

public class Framed extends MiniApp {
	public static void main(String[] args) throws Exception {
		final int RADIUS = 10;
		
		int xCoord = WINDOW_WIDTH / 2;
		int yCoord = WINDOW_HEIGHT / 2;
				
		char key = 0;
		
		while (key != ESC_KEY) {
			key = getKey();
			
			switch (key) {
			case 'a':
				xCoord -= 2;
				break;
			case 'd':
				xCoord += 2;
				break;
			case 's':
				yCoord += 2;
				break;
			case 'w':
				yCoord -= 2;
				break;
			}
			
			if (xCoord < RADIUS) {
				xCoord = RADIUS;
			} else if (xCoord > WINDOW_WIDTH - RADIUS) {
				xCoord = WINDOW_WIDTH - RADIUS;
			}
			
			if (yCoord < RADIUS) {
				yCoord = RADIUS;
			} else if (yCoord > WINDOW_HEIGHT - RADIUS) {
				yCoord = WINDOW_HEIGHT - RADIUS;
			}
			
			fillCircle("ball", xCoord, yCoord, RADIUS, Color.BLACK);

		}
		
	}
}
