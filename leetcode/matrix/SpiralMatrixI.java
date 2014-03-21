package matrix;
/* Given a matrix of m x n elements (m rows, n columns), 
   return all elements of the matrix in spiral order. 
 */
import java.util.ArrayList;

public class SpiralMatrixI {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            res.add(null);
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int k = n;
        for (int i = 0; i < (m+1)/2 && k> 0 ; ++i) {
            for (int j = i; j < n-i; ++j)
                res.add(matrix[i][j]);
            if (i+1 == m-i) //2*i + 1 == m
                break;
            for (int j = i+1; j < m-i; ++j) 
                res.add(matrix[j][n-1-i]);
            if (n-2-i == i - 1) // 2*i + 1 == n
                break;
            for (int j = n-2-i; j > i; --j)
                res.add(matrix[m-1-i][j]);
            for (int j = m-1-i; j > i; --j) 
                res.add(matrix[j][i]);
            k -= 2; // 
        }
        return res;
    }
    
    public static void main(String args[]) {
        int[][] matrix = 
                {{1,5,10},{2,6,11},{3,7,12},{4,8,13}};
                         
        System.out.println(spiralOrder(matrix));
    }   
                
}