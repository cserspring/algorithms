package uncategorized;

import java.util.ArrayList;

public class PascalTriangle {
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(numRows <= 0)
			return res;
		for (int i = 0; i < numRows; ++i) {
			if (i==0) {
				ArrayList<Integer> firstRow = new ArrayList<Integer>();
				firstRow.add(1);
				res.add(firstRow);
			} else {
				ArrayList<Integer> iRow = new ArrayList<Integer>();
				iRow.add(1);
				for (int j = 1; j < i; ++j)
					iRow.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
				iRow.add(1);
				res.add(iRow);
			}
		}
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(5));
	}

}
