package matrix;
/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * */
import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions {
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public void solve(char[][] board) {
		if (board ==null)
			return;
		int m = board.length;
		if (m==0 || board[0] == null || board[0].length==0)
			return;
		int n = board[0].length;
		Queue<Point> queue = new ArrayDeque<Point>();
		
		// leftmost column and rightmost column
		for (int i = 0; i < m; ++i) {
			if (board[i][0]=='O') 
				queue.add(new Point(i,0));
			if (board[i][n-1]=='O')
				queue.add(new Point(i,n-1));
		}
		// topmost row and bottom row
		for (int j = 1; j < n-1; ++j) {
			if (board[0][j]=='O')
				queue.add(new Point(0,j));
			if (board[m-1][j]=='O')
				queue.add(new Point(m-1, j));
		}
		
		// Then BFS to get all of the 'O's
		while (!queue.isEmpty()) {
			Point p = queue.remove();
			int x = p.x;
			int y = p.y;
			board[x][y] = 'P';
			for (int i=-1;i<=1;++i) {
				for (int j = -1; j <=1; ++j) {
					if (x+i >=0 && x+i<=m-1 && y+j>=0 && y+j<=n-1 && Math.abs(i+j)==1) {
						if (board[x+i][y+j]=='O') {
							queue.add(new Point(x+i, y+j));
						}
					}
				}
			}
		}
		
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (board[i][j]=='P') 
					board[i][j]='O';
				else if (board[i][j]=='O')
					board[i][j]='X';
			}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegions s = new SurroundedRegions();
		char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
		s.solve(board);
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				System.out.print(board[i][j]);
					
			}
			System.out.println();
		}
	}

}
