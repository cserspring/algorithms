package recursive;

/*
 * Given a set of distinct integers, S, return all possible subsets.

   Note:
   Elements in a subset must be in non-descending order.
   The solution set must not contain duplicate subsets.
   For example,
   If S = [1,2,3], a solution is:

	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 * */
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (S == null)
			return null;
		res.add(new ArrayList<Integer>());
		Arrays.sort(S);
		return subsets(S, 0, res);

	}

	private static ArrayList<ArrayList<Integer>> subsets(int[] S, int start,
			ArrayList<ArrayList<Integer>> resTotal) {
		if (start == S.length)
			return resTotal;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(resTotal);

		for (int j = 0; j < resTotal.size(); ++j) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(resTotal.get(j));
			tmp.add(S[start]);
			res.add(tmp);
		}

		return subsets(S, start + 1, res);
	}

	public static ArrayList<ArrayList<Integer>> subsetsII(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (S==null)
			return res;
		Arrays.sort(S);
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length;++i) {
			int j = res.size();
			while (j-- > 0) {
				ArrayList<Integer> newResult = new ArrayList<Integer>(res.get(j));
				newResult.add(S[i]);
				res.add(newResult);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = { 1, 2, 3 };
		System.out.println(subsetsII(S));
	}

}
