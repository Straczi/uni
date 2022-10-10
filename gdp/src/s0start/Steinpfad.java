package s0start;

import std.ui.MiniApp;
import java.awt.Color;

public class Steinpfad extends MiniApp {
	public static void main(String[] args) {
		// Show left secondary river arm
		//placeBrick(3, true, 4, Color.BLUE);
		
		// Show main river
		/* 
		placeBrick(10, true, 8, Color.BLUE);
		placeBrick(10 + 8, true, 4, Color.BLUE);
		placeBrick(10 + 8 + 4, true, 1, Color.BLUE);
		*/

		// Show right secondary river arm
		//placeBrick(26, true, 1, Color.BLUE);
		
		
		placeBrick(29, true, 1, Color.RED);
		placeBrick(0, true, 1, Color.RED);
		placeBrick(7, true, 1, Color.RED);
		
		placeBrick(2, true, 1, Color.RED);
		
		placeBrick(2, true, 4, Color.RED);
		
		placeBrick(9, true, 1, Color.RED);
		
		placeBrick(9, true, 8, Color.RED);

	
		placeBrick(24, true, 1, Color.RED);
		placeBrick(25, true, 1, Color.RED);

		placeBrick(27, true, 1, Color.RED);


		placeBrick(24, false, 8, Color.RED);
		
		placeBrick(25, true, 1, Color.RED);
		
		placeBrick(26, true, 2, Color.RED);

		placeBrick(0, true, 2, Color.RED);
		placeBrick(6, true, 3, Color.RED);
		
		placeBrick(29, false, 2, Color.RED);
	}
}