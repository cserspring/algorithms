package uncategorized;

public class SortColors {
	public static void sortColors(int[] A) {
		int n = A.length;
		int p0 = 0; // Points to the position that 0 should be put on
		int p2 = n - 1; // Points to the position that 2 should be put on
		int i = 0;
		while (i <= p2) { // Use <= instead of <
			switch (A[i]) {
			case 0:
				swap(A, i, p0);
				++p0;
				++i;
				break;
			case 1:
				++i;
				break;
			case 2:
				swap(A, i, p2);
				--p2;
				break;
			}
		}
	}

	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		/*
		 * If we don't use <= in line 9, we will get wrong result
		 */
		int[] A = { 2, 0, 1 };
		sortColors(A);
		for (int i = 0; i < A.length; ++i)
			System.out.println(A[i]);
	}
}
