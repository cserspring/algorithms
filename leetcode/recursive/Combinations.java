package recursive;

import java.util.ArrayList;

public class Combinations {
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		return combine(n, 1, k);
	}

	public static ArrayList<ArrayList<Integer>> combine(int start, int end, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		if (k == 1) {
			for (int i = start; i >= end; --i) {
				ArrayList<Integer> oneResult = new ArrayList<Integer>();
				oneResult.add(i);
				res.add(oneResult);
			}
			return res;
		}
		for (int m = start; m >= end + k - 1; --m) {
			ArrayList<ArrayList<Integer>> tmpRes = combine(m - 1, end, k - 1);
			for (int i = 0; i < tmpRes.size(); ++i) {
				ArrayList<Integer> tmp = tmpRes.get(i);
				tmp.add(m);
				res.add(tmp);
			}
		}
		return res;
	}
	
	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> res = combine(4,2);
		System.out.println(res);
	}
}
