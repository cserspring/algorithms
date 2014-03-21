package sum;
/*
 * Given an array S of n integers, find three integers in S such that the sum is 
 * closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.

 * For example, given array S = {-1 2 1 -4}, and target = 1.

 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
import java.util.Arrays;

public class ThreeSumCloset {
    public static int threeSumClosest(int[] num, int target) {
        int sum;
        Arrays.sort(num);
        int res = num[0]+num[1]+num[num.length-1];
        for (int i = 0; i < num.length-2; ++i) {
            if (i != 0 && num[i] == num[i-1])
                continue;
            //sum = num[i] + num[i+1] + num[i+2];
            int start = i+1;
            int end = num.length-1;
            while (start < end) {
                sum = num[i] + num[start] + num[end];
                if (Math.abs(sum-target) < Math.abs(res-target))
                    res = sum;
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(threeSumClosest(num, -2));
    }

}
