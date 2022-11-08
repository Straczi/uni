package s5unit;

public class DebugMe4 {

	public static void main(String[] args) {
		int arr[] = { 9, 8, 3, 5, 6, 1, 2, 7, 4 };
		int zwischenSpeicher = 0;
		int i = 0;
		// bubblesort, für jede Zahl im Array, nimm die Zahl aus dem array
		// (arr[i]) vergleiche sie mit der nächsten arr[i+1] und wenn größer
		// vertausche sie
		// wenn nicht größer, nicht vertauschen
		for (i = arr.length - 1; i > 1;) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					zwischenSpeicher = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = zwischenSpeicher;
				}
			} 
			i--;
		}
		i = 0;
		// ausgabe!
		while (i < arr.length) {
			System.out.print(arr[i] + ",");
			++i;
		}

	}

}
