package suduko;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int N = 9;
		int[] flag = new int[N]; 
		for (int i = 0; i < N; ++i)
			flag[i] = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!(board[i][j] == '.'))
					flag[board[i][j]-'1']++;
			}
			for (int j = 0; j < N; ++j) {
				if (flag[j] > 1)
					return false;
			}
			for (int j = 0; j < N; ++j)
				flag[j] = 0;
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!(board[j][i] == '.'))
					flag[board[j][i]-'1']++;
			}
			for (int j = 0; j < N; ++j) {
				if (flag[j] > 1)
					return false;
			}
			for (int j = 0; j < N; ++j)
				flag[j] = 0;
		}
		
		for (int i = 0; i < N; i=i+3) {
			for (int j = 0; j < N; j=j+3) {
				for (int m = i; m <i+3; m++) {
					for (int n= j; n < j+3; n++) {
						if (!(board[m][n] == '.'))
							flag[board[m][n]-'1']++;
					}
				}
				
				for (int k = 0; k < N; ++k) {
					if (flag[k] > 1)
						return false;
				}
				for (int k = 0; k < N; ++k)
					flag[k] = 0;
			}
		}
        return true;
    }
}
