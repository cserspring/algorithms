package suduko;
/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

   Empty cells are indicated by the character '.'.

   You may assume that there will be only one unique solution.
 * */
public class SudukoSolver {
	private int height;
	private int width;
	private final static int N = 3;

	public void solveSudoku(char[][] board) {
		solveSudokuHelper(board);
	}

	public boolean solveSudokuHelper(char[][] board) {
		this.height = board.length;
		this.width = board[0].length;
		int next = getNext(board);
		// We have solved the problem
		if (next == -1)
			return true;
		
		int i = next / width;
		int j = next % width;
		for (int k = 0; k < N * N; ++k) {
			board[i][j] = (char) ('1' + k);
			if (validCell(board, i, j) && solveSudokuHelper(board)) {
				return true;
			}
			board[i][j] = '.';
		}
		return false;

	}

	private int getNext(char[][] board) {
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				if (board[i][j] == '.') {
					return i * width + j;
				}
			}
		}
		return -1;
	}

	private boolean validCell(char[][] board, int i, int j) {
		// Whether is valid in the small square
		int row = i / N;
		int col = j / N;
		int[] flag = new int[N * N];
		for (int k = 0; k < N * N; ++k)
			flag[k] = 0;
		for (int m = row * N; m < N * (row + 1); ++m) {
			for (int n = col * N; n < N * (col + 1); ++n) {
				if (board[m][n] != '.')
					flag[board[m][n] - '0' - 1]++;
			}
		}
		for (int k = 0; k < N * N; ++k)
			if (flag[k] > 1)
				return false;

		// Whether the row is valid
		for (int k = 0; k < N * N; ++k)
			flag[k] = 0;
		for (int m = 0; m < N * N; ++m) {
			if (board[i][m] != '.')
				flag[board[i][m] - '0' - 1]++;
		}
		for (int k = 0; k < N * N; ++k)
			if (flag[k] > 1)
				return false;

		// Whether the column is valid
		for (int k = 0; k < N * N; ++k)
			flag[k] = 0;
		for (int m = 0; m < N * N; ++m) {
			if (board[m][j] != '.')
				flag[board[m][j] - '0' - 1]++;
		}
		for (int k = 0; k < N * N; ++k)
			if (flag[k] > 1)
				return false;
		return true;
	}
}
