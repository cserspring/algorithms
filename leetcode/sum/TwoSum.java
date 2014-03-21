package sum;
/*
Given an array of integers, find two numbers such that they 
add up to a specific target number.

The function twoSum should return indices of the two numbers 
such that they add up to the target, where index1 must be less 
than index2. Please note that your returned answers 
(both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
import java.util.HashMap;

public class TwoSum {
    // O(n^2) Time Limit Exceeded
    public static int[] twoSumII(int[] numbers, int target) {
        int[] res = new int[2];
        boolean flag = false;
        for (int i = 0; i < numbers.length; ++i) {
            int remain = target - numbers[i];
            res[0] = i+1;
            for (int j = i+1; j < numbers.length; ++j) {
                if (numbers[j] == remain) {
                    res[1] = j+1;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        return res;
    }
    
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; ++i) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target-numbers[i]);
                res[1] = i+1;
                break;
            } else {
                map.put(numbers[i], i+1);
            }
        }
        return res;
    }
    
    public static void main(String args[]) {
        int[] numbers = {2, 7, 4, 3};
        int[] res = twoSum(numbers, 9);
        for (int i = 0; i < res.length; ++i)
            System.out.println(res[i]);
    }
}