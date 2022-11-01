package s5unit;

import java.util.Scanner;

import std.ui.MiniApp;

public class ConstructionSite extends MiniApp {
	public static int material = 0;
	public static int bricks = 0;
	
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		
		int p = scanner.nextInt();
		int w = scanner.nextInt();
		int f = scanner.nextInt();
		
		buildFloor(p, w, f);
		buildFloor(p, w, f);
		buildFloor(p, w, f);
		
		scanner.close();
	}
	
	static void buildWall(int p, int w, int h) {		
		for (int i = 0; i < h; i++) {
			int width = w;
			int pos = p;

			while(width > 0) {
				int maxBrickSize = getMaxBrickSize(width);
				placeBrick(pos, true, maxBrickSize);
				width -= maxBrickSize;
				pos += maxBrickSize;
				
				material += maxBrickSize;
				bricks++;
			}
		}
	}
	
	static void buildFloor(int p, int w, int f) {
		int pos = p;
		buildWall(pos, w, 2);
		
		buildWall(pos, f, 3);
		pos += 5 + f;
		buildWall(pos, w - f - 5, 3);
		
		pos = p;
		buildWall(pos, w, 1);
	}
	
	static int getMaxBrickSize(int b) {
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
