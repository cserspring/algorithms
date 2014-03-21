package matrix;

public class Search2DMatrix {
	// O(m+n)
	public static boolean  searchMatrixII(int[][] matrix, int target) {
        if (matrix==null || matrix.length == 0 || matrix[0].length == 0)
        	return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m-1;
        int j = 0;
        while (i >= 0 && j < n) {
        	if (matrix[i][j] == target) {
        		return true;
        	} else if (matrix[i][j] > target) {
        		i--;
        	} else if (matrix[i][j] < target) {
        		j++;
        	}
        }
        return false;
    }
	
	// O(lg(m*n)) = O(lgm + lgn)
	public static boolean  searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length == 0 || matrix[0].length == 0)
        	return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0; 
        int high = m*n - 1;
        while (low <= high) {
        	int mid = (low+high)/2;
        	int i = mid/n;
        	int j = mid%n;
        	if (matrix[i][j] == target) {
        		return true;
        	} else if (matrix[i][j] > target) {
        		high = mid - 1;
        	} else {
        		low = mid +1;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
		                  {1,   3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}
		};
		System.out.println(searchMatrix(matrix, 3));
	}

}
