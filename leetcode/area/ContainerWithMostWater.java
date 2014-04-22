package area;

/* Given n non-negative integers a1, a2, ..., an, where each represents a 
 * point at coordinate (i, ai). n vertical lines are drawn such that the two 
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together 
 * with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container. */
public class ContainerWithMostWater {
	// O(n^2)
	public int maxAreaII(int[] height) {
		int n = height.length;
		int max = 0;

		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int area = (j - i) * (Math.min(height[j], height[i]));
				if (area > max)
					max = area;
			}
		}
		return max;
	}

	public int maxArea(int[] height) {
		int n = height.length;
		int max = 0;

		int left = 0;
		int right = n - 1;
		while (left < right) {
			int area = 0;
			if (height[left] < height[right]) {
				area = height[left] * (right - left);
				left++;
			} else {
				area = height[right] * (right - left);
				right--;
			}
			if (max < area)
				max = area;
		}
		return max;
	}

	public static void main(String[] args) {

	}
}
