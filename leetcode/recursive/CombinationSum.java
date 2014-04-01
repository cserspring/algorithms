package recursive;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(candidates);
		int end = removeDups(candidates);
		ArrayList<Integer> oneResult = new ArrayList<Integer>();
		combine(res, candidates, 0, end, oneResult, target);
		return res;
    }
	
	private int removeDups(int[] A) {
		int pos = 0;
		int i = 1;
		for (; i < A.length; ++i) {
			if (A[i]!=A[i-1]) {
				++pos;
				int tmp = A[pos];
				A[pos] = A[i];
				A[i] = tmp;
			}
		}
		return ++pos;
	}
	private void combine(ArrayList<ArrayList<Integer>> res, int[] candidates, int start, int end, ArrayList<Integer> oneResult, int target) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(oneResult);
			return;
		}
		
		for (int i = start; i < end; ++i) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(oneResult);
			tmp.add(candidates[i]);
			combine(res, candidates, i, end, tmp, target - candidates[i]);
		}
	}
	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		int[] A = {2,3,6,7};
		int target = 7;
		System.out.println(c.combinationSum(A,target));
	}

}
