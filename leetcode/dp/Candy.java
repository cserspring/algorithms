package dp;
/*
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 * */
public class Candy {
	public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
        	return 0;
        int n = ratings.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
        	if (ratings[i] >ratings[i-1]) {
        		dp[i] = 1+ dp[i-1];
        	} else {
        		dp[i] = 1;
        	}
        }
        
        for (int i = n-1; i >= 1;--i) {
        	if (ratings[i-1] >ratings[i] && dp[i-1] <= dp[i]) {
        		dp[i-1] = 1+dp[i];
        	}
        }
        int sum = 0;
        for (int i = 0; i < n; ++i)
        	sum+=dp[i];
        return sum;
    }
	public static void main(String args[]) {
		int[] ratings = {3,1,4,2,1,3,5};
		System.out.println(candy(ratings));
	}
}
