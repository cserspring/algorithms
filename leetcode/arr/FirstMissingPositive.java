package arr;

/*
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 * */
public class FirstMissingPositive {
	public static int firstMissingPositive(int[] A) {
		int n = A.length;
		for (int i = 0; i < n; ++i) {
			if (A[i] > 0 && A[i] < n) {
				if ((A[i] - 1 != i) && (A[A[i] - 1] != A[i])) {
					int tmp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = tmp;
					--i;
				}
			}
		}

		for (int i = 0; i < n; ++i) {
			if (A[i] - i != 1)
				return i + 1;
		}
		return n + 1;
	}

	public static void main(String[] args) {
		int[] A = { -1, -1, -1 };
		System.out.println(firstMissingPositive(A));
	}

}
