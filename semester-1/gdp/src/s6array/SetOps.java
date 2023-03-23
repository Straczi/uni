package s6array;

public class SetOps {
	int abc;

	public static void main(String[] args) {
		char[] a = {};
		char[] b = { 'a', 'b', 'c' };
		System.out.println(isSubsetOf(a, b));
	}

	public static boolean isEqualTo(char[] a, char[] b) {
		return isSubsetOf(a, b) && isSubsetOf(b, a);
	}

	public static boolean isSubsetOf(char[] a, char[] b) {
		for (char c : a) {
			if (!contains(b, c)) {
				return false;
			}
		}

		return true;
	}

	private static boolean contains(char[] haystack, char needle) {
		for (char c : haystack) {
			if (c == needle) {
				return true;
			}
		}

		return false;
	}
}
