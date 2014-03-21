package dp;
/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 * */
public class GasStation {
	public int canCompleteCircuitII(int[] gas, int[] cost) {
        int n = gas.length;
        if (n ==0)
        	return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i)
        	dp[i] = gas[i] - cost[i];
        int index = -1;
        for (int i = 0; i < n; ++i) {
        	int sum = 0;
        	int j = 0;
        	for (; i < n; ++j) {
        		sum += dp[(i+j)%n];
        		if (sum < 0)
        			break;
        	}
        	if (j==n) {
        		index = i;
        		break;
        	}
        }
        return index;
    }
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n ==0)
        	return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i)
        	dp[i] = gas[i] - cost[i];
        int index = -1;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < n; ++i) {
        	sum += dp[i];
        	total += dp[i];
        	if (sum < 0) {
        		index = i;
        		sum = 0;
        	}
        }
        if (total < 0)
        	return -1;
        return index+1;
    }
}
