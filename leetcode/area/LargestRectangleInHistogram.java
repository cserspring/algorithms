package area;

/* Given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1, find the area of largest rectangle in the histogram. 
 * */
import java.util.Stack;

public class LargestRectangleInHistogram {
	// O(n^2)
	public static int largestRectangleAreaII(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int len = height.length;
		int area = 0;

		int[] L = new int[len];
		int[] R = new int[len];
		for (int i = 0; i < len; ++i) {
			L[i] = 0;
			R[i] = 0;
		}
		for (int i = 0; i < len; ++i) {
			L[i] = i;
			R[i] = len;
			for (int j = i + 1; j < len; ++j) {
				if (height[j] < height[i]) {
					R[i] = j;
					break;
				}
			}
			for (int j = i - 1; j >= 0; --j) {
				if (height[j] < height[i]) {
					L[i] = j + 1;
					break;
				}
			}
		}

		for (int i = 0; i < len; ++i) {
			area = Math.max(area, height[i] * (R[i] - L[i]));
		}
		return area;
	}

	public static int largestRectangleAreaIII(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int len = height.length;
		int area = 0;
		Stack<Integer> indexes = new Stack<Integer>();
		int i = 0;
		int t;
		int tmpArea;
		while (i < len) {
			if (indexes.isEmpty() || height[i] >= height[indexes.peek()]) {
				indexes.push(i++);
			} else {
				t = indexes.peek();
				indexes.pop();
				tmpArea = (indexes.isEmpty() ? i : (i - indexes.peek() - 1))
						* height[t];
				if (tmpArea > area)
					area = tmpArea;
			}
		}
		while (!indexes.isEmpty()) {
			t = indexes.peek();
			indexes.pop();
			tmpArea = (indexes.isEmpty() ? i : (i - indexes.peek() - 1))
					* height[t];
			if (tmpArea > area)
				area = tmpArea;
		}
		return area;
	}

	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int len = height.length;

		int[] newHeight = new int[len + 1];
		for (int i = 0; i < len; ++i)
			newHeight[i] = height[i];
		newHeight[len] = 0;

		int area = 0;
		Stack<Integer> indexes = new Stack<Integer>();
		int i = 0;
		int t;
		int tmpArea;
		while (i < len + 1) {
			if (indexes.isEmpty() || newHeight[i] >= newHeight[indexes.peek()]) {
				indexes.push(i++);
			} else {
				t = indexes.peek();
				indexes.pop();
				tmpArea = (indexes.isEmpty() ? i : (i - indexes.peek() - 1))
						* newHeight[t];
				if (tmpArea > area)
					area = tmpArea;
			}
		}
		return area;
	}

	public static void main(String[] args) {
		// To draw this pic to enhance your understanding
		int val[] = { 2, 3, 4, 2, 1 };
		System.out.println(largestRectangleArea(val));
	}

}
