package s7data;

public class UniqueArray {
	public static void main(String[] args) {
		System.out.println(unique(new int[]{2, 2}));
	}
	
	public static int unique(int[] numbers) {
		int numUnique = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			int count = 0;
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					count++;
				}
			}
			
			if (count < 2) {
				numUnique++;
			}
		}
		
		return numUnique;
	}
}
