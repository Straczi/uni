package s0start;
 
 import std.ui.MiniApp;
 import java.awt.Color;
 
 public class Steinreihe extends MiniApp {
 	public static void main(String[] args) {
		placeBrick(0, true, 1, Color.BLUE);
		placeBrick(1, true, 2, Color.BLUE);
		placeBrick(1 + 2, true, 3, Color.BLUE);
		placeBrick(1 + 2 + 3, true, 4, Color.BLUE);
		placeBrick(1 + 2 + 3 + 4, true, 6, Color.BLUE);
		placeBrick(1 + 2 + 3 + 4 + 6, true, 8, Color.BLUE);
		placeBrick(1 + 2 + 3 + 4 + 6 + 8, true, 6, Color.BLUE);
 	}
 }