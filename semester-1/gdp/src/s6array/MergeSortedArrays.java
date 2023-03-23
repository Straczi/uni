package s6array;

public class MergeSortedArrays {
	public static void main(String[] args) {

	}
	
	public static int[] merge(int[] a, int[] b) {
		int[] out = new int[a.length + b.length];
		int aIndex = 0;
		int bIndex = 0;
		
		for (int i = 0; i < out.length; i++) {
			if (aIndex < a.length && bIndex < b.length && a[aIndex] < b[bIndex]) {
				out[i] = a[aIndex];
				aIndex++;
			} else if (aIndex < a.length && bIndex < b.length && b[bIndex] < a[aIndex]) {
				out[i] = b[bIndex];
				bIndex++;
			} else if (aIndex < a.length) {
				out[i] = a[aIndex];
				aIndex++;
			} else {
				out[i] = b[bIndex];
				bIndex++;
			}
		}
		
		
		return out;
	}
}
