package sum;
/*
 * To find the k numbers whose sum is 'target'.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class KSum {
    public static ArrayList<ArrayList<Integer>> ksum(int[] num, int target,
            int k) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = ksum_internal(num, 0,
                num.length - 1, target, k);
        return res;
    }

    private static ArrayList<ArrayList<Integer>> ksum_internal(int[] num,
            int start, int end, int target, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (k == 2) {
            while (start < end) {
                if (num[start] + num[end] == target) {
                    ArrayList<Integer> subRes = new ArrayList<Integer>();
                    subRes.add(num[start++]);
                    subRes.add(num[end--]);
                    res.add(subRes);
                    while (start < end && num[start] == num[start - 1])
                        start++;
                    while (start < end && num[end] == num[end + 1])
                        end--;
                } else if (num[start] + num[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
        } else if (k > 2) {
            // for (int i = start; i <= end+1-k; ++i) {
            // if ((i != start) && num[i] == num[i-1])
            // continue;
            // ArrayList<ArrayList<Integer>> tmpRes = ksum_internal(num,
            // i + 1, end, target - num[i], k - 1);
            // for (int j = 0; j < tmpRes.size(); ++j) {
            // tmpRes.get(j).add(0, num[i]); //Insert at the front
            // res.add(tmpRes.get(j));
            // }
            // }

            for (int i = end; i >= start + k - 1; --i) {
                if ((i != end) && num[i] == num[i + 1])
                    continue;
                ArrayList<ArrayList<Integer>> tmpRes = ksum_internal(num,
                        start, i - 1, target - num[i], k - 1);
                for (int j = 0; j < tmpRes.size(); ++j) {
                    tmpRes.get(j).add(num[i]); // Only need to insert at the end
                    res.add(tmpRes.get(j));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int num[] = { -1, 0, 1, 2, -1, -4 };
        ArrayList<ArrayList<Integer>> res = ksum(num, 0, 3);
        for (int i = 0; i < res.size(); ++i) {
            for (int j = 0; j < res.get(i).size(); ++j) {
                System.out.print(res.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

}
