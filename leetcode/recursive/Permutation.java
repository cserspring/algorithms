package recursive;
/*
 * Given a collection of numbers, return all possible permutations.

   For example,
   [1,2,3] have the following permutations:
   [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * */
import java.util.ArrayList;

public class Permutation {
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        return permute_internal(num, num.length);
    }

    private static ArrayList<ArrayList<Integer>> permute_internal(int[] num,
            int len) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        // here, we need to add a null to res
        if (num == null || len == 0) {
            ArrayList<Integer> subres = new ArrayList<Integer>();
            res.add(subres);
            return res;
        }

        int tmp = num[len - 1];
        ArrayList<ArrayList<Integer>> tmpRes = permute_internal(num, len - 1);
        for (int j = 0; j < tmpRes.size(); ++j) {
            for (int k = 0; k <= tmpRes.get(j).size(); ++k) {
                ArrayList<Integer> subRes = new ArrayList<Integer>(
                        tmpRes.get(j));
                subRes.add(k, tmp);
                res.add(subRes);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = { 1, 2, 3 };
        System.out.println(permute(num));
    }

}
