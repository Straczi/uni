package s4func;

public class Knight {
	
	static long mark(long field, int row, int column) {
		return field | (1L << ((row * 8) + column));
	}
	
	static long markIfValid(long field, int row, int column) {
		if (row >= 0 && row <= 7 && column >= 0 && column <= 7) {
			field = mark(field, row, column);
		}
		
		return field;
	}
	
	static String asString(long field) {
		String fieldString = "";
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (((field >> j + i * 8) & 1) == 1) {
					fieldString += 'X';
				} else {
					fieldString += 'O';
				}
			}
			
			fieldString += '\n';
		}
		
		return fieldString;
	}
	
	static long reachable(int row, int column) {
		long field = 0L;
		
		field = markIfValid(field, row + 2, column + 1);
		field = markIfValid(field, row + 2, column - 1);
		
		field = markIfValid(field, row - 2, column + 1);
		field = markIfValid(field, row - 2, column - 1);
		
		field = markIfValid(field, row + 1, column - 2);
		field = markIfValid(field, row - 1, column - 2);
		
		field = markIfValid(field, row + 1, column + 2);
		field = markIfValid(field, row - 1, column + 2);
		
		return field;
	}
}
