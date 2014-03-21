package matrix;
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int val = 1;

        for (int i = 0; i < (n + 1) / 2; ++i) {
            for (int j = i; j < n - i; ++j) {
                res[i][j] = val++;
            }

            if (2 * i + 1 == n)
                break;

            for (int j = i + 1; j < n - i; ++j) {
                res[j][n - 1 - i] = val++;
            }
            // if (2*i + 1 == n)

            for (int j = n - 2 - i; j >= i; --j) {
                res[n - 1 - i][j] = val++;
            }

            for (int j = n - 2 - i; j > i; --j) {
                res[j][i] = val++;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        // int[][] matrix =
        // {{1,5,10},{2,6,11},{3,7,12},{4,8,13}};
        int n = 4;
        int[][] matrix = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }
}