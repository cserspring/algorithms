package uncategorized;

/*
 * Given a 2D board and a word, find if the word exists in the grid.

   The word can be constructed from letters of sequentially adjacent cell, 
   where "adjacent" cells are those horizontally or vertically neighboring. 
   The same letter cell may not be used more than once.

   For example,
   Given board =

   [
    ["ABCE"],
    ["SFCS"],
    ["ADEE"]
   ]
   word = "ABCCED", -> returns true,
   word = "SEE", -> returns true,
   word = "ABCB", -> returns false.
 * */
public class WordSearch {
	private int m;
	private int n;

	public boolean exist(char[][] board, String word) {
		m = board.length;
		n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				visited[i][j] = false;
			}
		}

		boolean flag = false;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					flag |= exist(board, visited, word.substring(1), i, j);
					//在这里直接返回
					//其实这里不用用这个flag，直接if (exist()) return true就行了
					if (flag)
						return true;
					visited[i][j] = false;
				}
			}
		}
		
		return flag;
	}

	private boolean exist(char[][] board, boolean[][] visited, String word,
			int x, int y) {
		if (word.length()==0)
			return true;
		boolean flag = false;
		for (int p = -1; p <= 1; p++) {
			for (int q = -1; q <= 1; q++) {
				if (x + p >= 0 && x + p < m && y + q >= 0 && y + q < n
						&& Math.abs(p) != Math.abs(q)) {
					if (!visited[x + p][y + q]
							&& board[x + p][y + q] == word.charAt(0)) {
						visited[x + p][y + q] = true;
						flag |= exist(board, visited, word.substring(1), x + p,
								y + q);
						if (flag)
							return true;
						visited[x + p][y + q] = false;
					}
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix= {{'A','B','C','E'},
				  {'S','F','C','S'},
				  {'A','D','E','E'}};
		WordSearch w = new WordSearch();
		System.out.println(w.exist(matrix, "ABCCED"));
	}

}
