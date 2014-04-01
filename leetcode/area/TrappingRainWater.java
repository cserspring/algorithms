package area;
/*
 * Given n non-negative integers representing an elevation map where the width 
 * of each bar is 1, compute how much water it is able to trap after raining.

   For example, 
   Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * */
public class TrappingRainWater {
	/* O(n) solution. for each bar, find the max height bar on the left and right. 
	 * then for this bar it can hold min(max_left, max_right) - height */
	public static int trap(int[] A) {
		int n = A.length;
		if (n == 0)
			return 0;
		int[] maxLeft = new int[n];
		int[] maxRight = new int[n];
		maxLeft[0] = -1;
		maxRight[n-1] = -1;
		int sum = 0;
		for (int i = 1; i < n; ++i) {
			maxLeft[i] = Math.max(maxLeft[i-1], A[i-1]);
		}
		for (int i = n-2; i >= 0; --i) {
			maxRight[i] = Math.max(maxRight[i+1], A[i+1]);
		}
		
		for (int i = 0; i < n; ++i) {
			int min = Math.min(maxLeft[i], maxRight[i]);
			if (min-A[i] > 0)
				sum += min - A[i];
		}
		return sum;
    }
	
	public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}

}
