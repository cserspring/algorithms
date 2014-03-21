package uncategorized;

import java.util.ArrayList;

public class Triangle {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows-1).size();
        int[] dp = new int[cols+1];
        for (int i = 0; i < cols +1; ++i)
        	dp[i] = 0;
        for (int i = cols-1; i >= 0; --i) {
        	for (int j = 0; j < triangle.get(i).size(); ++j) {
        		dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        	}
        }
        return dp[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
