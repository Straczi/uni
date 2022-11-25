package testat2;

public class FunctionArrays {
	public static long FACTOR = 100L;

	public static void main(String[] args) {
		long[] values = { 0, 600, 12300, 24512, -3345 };
		long[][] values2 = {
				{ 3245, -1234, 2654, 0 },
				{ 25, 7, -2343251, 2323 },
				{ -34352, 526, 4, -4 }
		};
		
		long[][] values3 = {
				{ 3245, -1234, 2654, 0 },
				{ 25, 7, -2343251, 2323 },
				{},
				{ -34352, 526, 4, -4 },
				{}
		};

		assert isEvenNumber(0);
		assert isEvenNumber(2);
		assert !isEvenNumber(3);
		assert isEvenNumber(-2);
		assert !isEvenNumber(-3);
		assert isEvenNumber(((long) Integer.MAX_VALUE) + 2);

		assert countEvenNumbers(values) == 4;
		assert countEvenNumbers(new long[] {}) == 0;
		assert countEvenNumbers(new long[] { -2, -4, -1324257, 12, 232435245 }) == 3;

		assert countEvenNumbersInMatrix(values2).equals(new int[] { 3, 0, 4 });
		assert countEvenNumbersInMatrix(values2).equals(new int[] { 3, -1, 0, 4, -1 });

		assert filter(values).equals(new long[] { 0, 600, 12300 });
		assert filter(values).equals(new long[] { 0, 600, 12300, 2314, 992183 });
		assert filter(values).equals(new long[] { 0, 600, 12300, 1, 2, 3, 2415425 });
		assert filter(values2[0]).equals(new long[] {0});
		assert filter(values2[0]).equals(new long[] {});
		assert filter(values2[0]).equals(new long[] {});
		assert filter(new long[] {}).equals(new long[] {});

		System.out.println("All tested");
	}

	public static boolean isEvenNumber(long number) {
		return number % 2 == 0;
	}

	public static int countEvenNumbers(long[] numbers) {
		int count = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (isEvenNumber(numbers[i])) {
				count++;
			}
		}

		return count;
	}

	public static int[] countEvenNumbersInMatrix(long[][] matrix) {
		int[] counts = new int[matrix.length];

		for (int i = 0; i < counts.length; i++) {
			if (matrix[i].length == 0) {
				counts[i] = -1;
			} else {
				counts[i] = countEvenNumbers(matrix[i]);
			}
		}

		return counts;
	}

	public static long[] filter(long[] numbers) {
		long[] filtered = new long[numbers.length];
		int count = 0;

		for (int i = 0; i < filtered.length; i++) {
			if (numbers[i] % FACTOR == 0) {
				filtered[count] = numbers[i];
				count++;
			}
		}

		return filtered;
	}
}
