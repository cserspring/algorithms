package area;

public class ContainerWithMostWater {
	// O(n^2)
	public int maxAreaII(int[] height) {
        int n = height.length;
        int max = 0;
        
        if (n == 0)
        	return max;
        for (int i = 0; i < n-1; ++i) {
        	for (int j = i+1; j < n; ++j) {
        		int area = (j - i) * (Math.abs(height[j] - height[i]));
        		if (area > max)
        			max = area;
        	}
        }
        return max;
    }
	
	public int maxArea(int[] height) {
		int n = height.length;
        int max = 0;
        
        if (n == 0)
        	return max;
        int left = 0;
        int right = n-1;
        while (left < right) {
        	int area = 0;
        	if (height[left] < height[right]) {
        		area = height[left]*(right-left);
        		left++;
        	} else {
        		area = height[right]*(right-left);
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
