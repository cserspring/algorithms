package recursive;

/* Given two integers n and k, return all possible combinations of k numbers 
 * out of 1 ... n.

 * For example,
 * If n = 4 and k = 2, a solution is:

 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * */
import java.util.ArrayList;

public class Combinations {
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (k == 0) {
			ArrayList<Integer> oneResult = new ArrayList<Integer>();
			res.add(oneResult);
		} else {
			for (int i = n; i >= k; --i) {
				ArrayList<ArrayList<Integer>> partRes = combine(i - 1, k - 1);
				for (int j = 0; j < partRes.size(); ++j) {
					ArrayList<Integer> oneResult = partRes.get(j);
					oneResult.add(i);
					res.add(oneResult);
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> res = combine(4, 2);
		System.out.println(res);
	}
}
