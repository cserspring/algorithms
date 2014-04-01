package dp;

import java.util.Arrays;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

   Each element in the array represents your maximum jump length at that position.

   Your goal is to reach the last index in the minimum number of jumps.

   For example:
   Given array A = [2,3,1,1,4]

   The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
   then 3 steps to the last index.)
 * */
public class JumpGameII {
	/* http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html */
	public static int jump(int[] A) {
		int last = 0;
		int cur = 0;
		int ret = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			if (i > last) {
				last = cur;
				++ret;
			}
			cur = Math.max(cur, A[i] + i);
		}
		return ret;
	}
	
	/*
	 * dp[i] = min(dp[j] + 1); j < i && i-j <= dp[j]
	 * */
	public static int jumpII(int[] A) {
		int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; ++i) {
        	for (int j = 0; j < i; ++j) {
        		if (A[j] >= i-j)
        			dp[i] = Math.min(dp[i], dp[j]+1);
        	}
        }
        return dp[n-1];
    }
	
	public static void main(String args[]) {
		int[] A = {2,3,1,1,4};
		System.out.println(jump(A));
	}
}
