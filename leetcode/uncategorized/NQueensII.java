package uncategorized;

public class NQueensII {
	int[] rows;
	int num;

	private boolean check(int i, int j) {
		for (int r = 0; r < i; ++r) {
			if (rows[r] == j || Math.abs(r - i) == Math.abs(rows[r] - j))
				return false;
		}
		return true;
	}

	private void place(int start, int n) {
		if (start == n) {
			++num;
		} else {
			for (int j = 0; j < n; ++j) {
				if (check(start, j)) {
					rows[start] = j;
					place(start + 1, n);
				}
			}
		}
	}

	public int totalNQueens(int n) {
		if (n <= 0)
			return 0;
		num = 0;
		rows = new int[n];
		for (int i = 0; i < n; ++i)
			rows[i] = -1;
		place(0, n);
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(4));
	}

}
