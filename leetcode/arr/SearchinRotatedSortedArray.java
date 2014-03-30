package arr;
/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

   You are given a target value to search. If found in 
   the array return its index, otherwise return -1.

   You may assume no duplicate exists in the array.
 * */
public class SearchinRotatedSortedArray {
	public static int search(int[] A, int target) {
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			int mid = (left + right)/2;
			if (A[mid] == target)
				return mid;
			if (A[left] <= A[mid]) {
				if (A[left] <= target && target < A[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (target > A[mid] && target <= A[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return -1;
	}
	
	// Find the pivot
	public int FindSortedArrayRotation(int A[], int N) {
	    int L = 0;
	    int R = N - 1;

	    while (A[L] > A[R]) {
	        int M = L + (R - L) / 2;
	        if (A[M] > A[R])
	            L = M + 1;
	        else
	            R = M;
	    }
	    return L;
	}
	
	public static void main(String args[]) {
		int A[] = {0, 1, 2, 4, 5, 6, 7};
		System.out.println(search(A, 5));
	}
}
