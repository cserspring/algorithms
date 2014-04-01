package dp;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

   Each element in the array represents your maximum jump length at that position.

   Determine if you are able to reach the last index.

   For example:
   A = [2,3,1,1,4], return true.

   A = [3,2,1,0,4], return false.
 * */
public class JumpGame {
	public static boolean canJump(int[] A) {
        int n = A.length;
        int max = 0;
        for (int i = 0; i < n && i <= max; ++i) {
        	int steps = A[i] + i;
        	if (max < steps)
        		max = steps;
        	if (max >= n-1)
        		return true;
        }
        return false;
    }
	public static void main(String[] args) {
		int[] A = {3,2,1,0,4};
		System.out.println(canJump(A));
	}

}
