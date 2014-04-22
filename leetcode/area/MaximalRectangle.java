package area;

/* Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area. 
 */
public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		// Every column
		int[] H = new int[n];
		int[] L = new int[n];
		int[] R = new int[n];
		for (int i = 0; i < n; ++i) {
			H[i] = 0;
			L[i] = 0;
			R[i] = n;
		}
		int left, right;
		int area = 0;
		for (int i = 0; i < m; ++i) {
			left = 0;
			right = n;
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == '1') {
					++H[j];
					L[j] = max(L[j], left);
				} else {
					left = j + 1;
					H[j] = 0;
					L[j] = 0;
					R[j] = n;
				}
			}

			for (int j = n - 1; j >= 0; --j) {
				if (matrix[i][j] == '1') {
					R[j] = min(R[j], right);
					area = max(area, H[j] * (R[j] - L[j]));
				} else {
					right = j;
				}
			}
		}
		return area;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static int min(int a, int b) {
		return a > b ? b : a;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '0', '1', '1', '0', '1' },
				{ '1', '1', '0', '1', '0' }, { '0', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(maximalRectangle(matrix));
	}

}
