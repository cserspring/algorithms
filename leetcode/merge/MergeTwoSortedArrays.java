package merge;

/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 Note:
 You may assume that A has enough space (size that is greater or equal to m + n) to hold
 additional elements from B. The number of elements initialized in A and B are m and n 
 respectively.
 * */
public class MergeTwoSortedArrays {
	public static void mergeII(int A[], int m, int B[], int n) {
		int sum = m + n;
		int i = sum;
		if (m != 0 && n != 0) {
			i = sum - 1;
			for (; i >= 0; --i) {
				A[i] = A[m - 1] > B[n - 1] ? A[--m] : B[--n];
				if (m == 0 || n == 0)
					break;
			}
		}
		while (--m >= 0) {
			A[--i] = A[m];
		}
		while (--n >= 0) {
			A[--i] = B[n];
		}
	}

	public void mergeIII(int A[], int m, int B[], int n) {
		int len = m + n;
		for (int i = len - 1; i >= 0; --i) {
			if (m <= 0)
				A[i] = B[--n];
			else if (n <= 0)
				A[i] = A[--m];
			else
				A[i] = A[m - 1] > B[n - 1] ? A[--m] : B[--n];
		}
	}

	public static void merge(int A[], int m, int B[], int n) {
		int sum = m + n;
		int i = sum - 1;
		/* After n == 0, we don't need to make the copy of A[i] = A[i] */
		while (n > 0) {
			if (m <= 0 || A[m - 1] < B[n - 1])
				A[i--] = B[--n];
			else
				A[i--] = A[--m];
		}
	}

	public static void main(String args[]) {
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 2;
		A[2] = 4;
		int B[] = { -8, 3, 9 };
		merge(A, 3, B, 3);
		for (int i = 0; i < 10; ++i)
			System.out.println(A[i]);
	}
}
