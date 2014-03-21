package uncategorized;

import java.util.ArrayList;

public class NQueens {
	int[] rows;
	ArrayList<String[]> res;
	private boolean check(int i, int j) {
		for (int r = 0; r < i; ++r) {
			if (rows[r] == j || Math.abs(r-i) == Math.abs(rows[r]-j))
				return false;
		}
		return true;
	}
	
	private void place(int start, int n) {
		if (start ==n) {
			StringBuilder[] rowString = new StringBuilder[n];
			for (int i = 0; i < n; ++i) {
				rowString[i] = new StringBuilder();
				for (int j = 0; j < n; ++j) {
					rowString[i].append('.');
				}
			}
			for (int i = 0; i < n; ++i) {
				rowString[i].setCharAt(rows[i], 'Q');
			}
			String[] subRes = new String[n];
			for (int i = 0; i < n; ++i)
				subRes[i] = rowString[i].toString();
			res.add(subRes);
		} else {
			
				for (int j = 0; j < n; ++j) {
					if (check(start,j)) {
						rows[start] = j;
						place(start+1, n);
					}
				}
			
		}
	}
	public ArrayList<String[]> solveNQueens(int n) {
		res = new ArrayList<String[]>();
		if (n <= 0)
			return res;
		rows = new int[n];
		for (int i = 0; i < n; ++i)
			rows[i] = -1;
		place(0, n);
		return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens nq = new NQueens();
		ArrayList<String[]> res = nq.solveNQueens(4);
		for (int i = 0; i < res.size(); ++i) {
			for (int j = 0; j < res.get(i).length; ++j) {
				System.out.println(res.get(i)[j]);
			}
			System.out.println();
		}
	}

}
