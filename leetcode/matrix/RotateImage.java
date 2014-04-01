package matrix;

/*
 * You are given an n x n 2D matrix representing an image.

   Rotate the image by 90 degrees (clockwise).

   Follow up:
   Could you do this in-place?
 * */
public class RotateImage {
	public void rotate(int[][] matrix) {
        int N = matrix.length;
        
        for (int i = 0; i < N/2; ++i) {
        	for (int j = i; j < N - i - 1; ++j) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[N-1-j][i];
        		matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
        		matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
        		matrix[j][N-1-i] = tmp;
        	}
        }
    }
}
