package matrix;
/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?
 * */

/*
 * 1. To see whether the first row and first col contains 0
 * 2. Then use first row and col to save the rows and cols which should be set 0
 * */
public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowSetZero = false;
        boolean firstColSetZero = false;
        for (int i = 0; i < cols; ++i)
        	if (matrix[0][i] == 0)
        		firstRowSetZero = true;
        for (int i = 0; i < rows; ++i)
        	if (matrix[i][0] == 0)
        		firstColSetZero = true;
        
        for (int i = 1; i < rows; ++i) {
        	for (int j = 1; j < cols; ++j) {
        		if (matrix[i][j] == 0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        
        for (int i = 1; i < rows; ++i) {
        	for (int j = 1; j < cols; ++j) {
        		if (matrix[i][0] == 0 || matrix[0][j] == 0) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        if (firstColSetZero) {
        	for (int i = 0; i < rows; ++i)
        		matrix[i][0] = 0;
        }
        
        if (firstRowSetZero) {
        	for (int i = 0; i < cols; ++i)
        		matrix[0][i] = 0;
        }
    }
}
