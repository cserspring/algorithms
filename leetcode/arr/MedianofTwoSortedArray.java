package arr;

/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * */
public class MedianofTwoSortedArray {

	public static double findMedianSortedArrays(int A[], int B[]) {
		if ((A == null || A.length == 0) && (B == null || B.length == 0))
			return 0;
		if (A == null || A.length == 0)
			return findMedianInAnArray(B);
		if (B == null || B.length == 0)
			return findMedianInAnArray(A);
		int alen = A.length;
		int blen = B.length;
		int sum = alen+blen;
		
		int mid = sum/2;
		int rem = sum%2;
		if (rem == 1) {
			return median(A, B, 0, alen, 0, blen, mid+1);
		} else {
			return (median(A, B, 0, alen, 0, blen, mid) + median(A, B, 0, alen, 0, blen, mid+1))/2;
		}
	}

	public static double median(int[] A, int[] B, int astart, int aend, int bstart, int bend, int k) {
		int alen = aend - astart;
		int blen = bend - bstart;
		if (alen > blen)
			return median(B, A, bstart, bend, astart, aend, k);
		if (alen == 0)
			return (double)B[bstart+k-1];
		// When K == 1, we need to process it.
		if (k == 1)
			return (double)Math.min(A[astart], B[bstart]);
		int pa = Math.min(astart+k/2, aend);
		int pb = bstart+astart+k-pa;
		if (A[pa-1] < B[pb-1]) {
			return median(A, B, pa, aend, bstart, bend, k-pa+astart);
		}
		if (A[pa-1] > B[pb-1]) {
			return median(A, B, astart, aend, pb, bend, k-pb+bstart);
		}
		return (double)A[pa-1];
	}
	
	private static double findMedianInAnArray(int[] A) {
		if (A.length%2 == 0) {
			return (double)(A[A.length/2 -1] + A[A.length/2])/2;
		} else {
			return (double)A[A.length/2];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1,2 };
		int[] B = {1,2,3};
		System.out.println(findMedianSortedArrays(A, B));
	}

}
