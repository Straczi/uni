package s5unit;

public class Power {
	/**
	 * Calculates the nth power of a number x.
	 * 
	 * @param x
	 * @param n
	 * @return nth power of a number x
	 */
	public static double power(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		double z = x;
		while (n > 1) {
			z *= x;
			n -= 1;
		}
		return z;
	}

	public static void main(String[] args) {
		System.out.println(power(3.0, 4));
	}
}
