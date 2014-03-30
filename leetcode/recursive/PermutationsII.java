package recursive;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 * */
public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length==0) 
			return res;
		Arrays.sort(num);
		int n = num.length-1;
		return permutation(num, 0, n);
    }
	
	private ArrayList<ArrayList<Integer>> permutation(int[] num, int start, int end) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (start == end) {
			ArrayList<Integer> oneResult = new ArrayList<Integer>();
			oneResult.add(num[start]);
			res.add(oneResult);
		} else {
			ArrayList<ArrayList<Integer>> subRes = permutation(num, start+1, end);
			for (int i = 0; i < subRes.size(); ++i) {
				ArrayList<Integer> oneResult = subRes.get(i);
				for (int j = 0; j <= oneResult.size(); ++j) {
					ArrayList<Integer> newResult = new ArrayList<Integer>(oneResult);
					newResult.add(j, num[start]);
					res.add(newResult);
					if (j != oneResult.size() && num[start] == oneResult.get(j))
						break;
				}
			}
		}
		return res;
	}
	
	public static void main(String args[]) {
		PermutationsII p = new PermutationsII();
		int[] num = {1,2,1};
		System.out.println(p.permuteUnique(num));
	}
}
