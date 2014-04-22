package recursive;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubsetsII {
	/* This one is the best */
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		int n = num.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> oneResult = new ArrayList<Integer>();
		res.add(oneResult);
		int start = 0;
		subsets(res, oneResult, num, start, n);
		return res;
	}

	private void subsets(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> oneResult, int[] num, int start, int n) {
		for (int i = start; i < n; ++i) {
			if (i > start && num[i] == num[i - 1])
				continue;
			ArrayList<Integer> newResult = new ArrayList<Integer>(oneResult);
			newResult.add(num[i]);
			res.add(newResult);
			subsets(res, newResult, num, i + 1, n);
		}
	}
	
	/* This method use the property of set */
	public static ArrayList<ArrayList<Integer>> subsetsWithDupIII(int[] num) {
		if (num == null)
			return new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		set.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; ++i) {
			// int j = set.size();
			HashSet<ArrayList<Integer>> newSet = new HashSet<ArrayList<Integer>>(
					set);
			for (ArrayList<Integer> one : newSet) {
				ArrayList<Integer> newResult = new ArrayList<Integer>(one);
				newResult.add(num[i]);
				set.add(newResult);
			}
		}
		return new ArrayList<ArrayList<Integer>>(set);
	}

	public static ArrayList<ArrayList<Integer>> subsetsWithDupII(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ret.add(new ArrayList<Integer>());

		int start = 0;
		for (int i = 0; i < num.length; i++) {
			int size = ret.size();
			for (int j = start; j < size; j++) {
				ArrayList<Integer> sub = new ArrayList<Integer>(ret.get(j));
				sub.add(num[i]);
				ret.add(sub);
			}
			if (i < num.length - 1 && num[i + 1] == num[i])
				start = size;
			else
				start = 0;
		}

		return ret;
	}
}
