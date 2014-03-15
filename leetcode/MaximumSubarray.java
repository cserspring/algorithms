package leetcode;

/*
 * Find the contiguous subarray within an array (containing at least 
 * one number) which has the largest sum.

   For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
   the contiguous subarray [4,−1,2,1] has the largest sum = 6.
   
   If you have figured out the O(n) solution, try coding another 
   solution using the divide and conquer approach, which is more subtle.
 * */
public class MaximumSubarray {
	public static int maxSubArrayII(int[] A) {
		int n = A.length;
		int res = Integer.MIN_VALUE;
		int sum = 0;
        for (int i = 0;i<n;++i) {
        	sum = A[i];
        	for (int j = i+1; j < n; ++j) {
        		sum+=A[j];
        		if (sum > res)
        			res = sum;
        	}
        }
        return res;
    }
	
	public static int maxSubArrayIII(int[] A) {
		int n = A.length;
		if (n==0)
			return 0;
		int max = A[0];
		int left = A[0];
		
        for (int i = 1;i<n;++i) {
        	if (left <= 0) {
        		left = A[i];
        		max = Math.max(max, left);
        	} else if (left + A[i] >= 0) {
        		left = left + A[i];
        		max = Math.max(max, left);
        	} else {
        		left = 0;
        	}
        }
        return max;
    }
	
	public static int maxSubArray(int[] A) {
		int n = A.length;
		if (n==0)
			return 0;
		int max = A[0];
		int sum = 0;
		
        for (int i = 0;i<n;++i) {
        	sum = Math.max(sum+A[i], A[i]);
        	max = Math.max(max, sum);
        }
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {6,2,-8,2,9,-8};
		System.out.println(maxSubArray(A));
	}

}
