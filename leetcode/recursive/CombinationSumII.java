package recursive;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		
		ArrayList<Integer> oneResult = new ArrayList<Integer>();
		combine(res, num, 0, oneResult, target);
		return res;
    }
	
	private void combine(ArrayList<ArrayList<Integer>> res, int[] candidates, int start, ArrayList<Integer> oneResult, int target) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(oneResult);
			return;
		}
		
		for (int i = start; i < candidates.length; ++i) {
			if (i > start && candidates[i] == candidates[i-1])
				continue;
			ArrayList<Integer> tmp = new ArrayList<Integer>(oneResult);
			tmp.add(candidates[i]);
			combine(res, candidates, i+1, tmp, target - candidates[i]);
		}
	}
	
	public static void main(String[] args) {
		CombinationSumII c = new CombinationSumII();
		int[] A = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(c.combinationSum2(A,target));
	}

}
