package arr;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();
        for (int i : num)
        	set.add(i);
        int max = 1;
        for (int i : num) {
        	if (set.contains(i)) {
        		max = Math.max(helper(set, i), max);
        	}
        }
        return max;
    }
	
	private int helper(HashSet<Integer> set, int val) {
		int count = 1;
		set.remove(val);
		int left = val;
		while (set.contains(--left)) {
			set.remove(left);
			++count;
		}
		int right = val;
		while (set.contains(++right)) {
			set.remove(right);
			++count;
		}
		return count;
	}
	
	public static void main(String args[]) {
		int[] num = {100, 4, 200, 1, 3, 2};
		LongestConsecutiveSequence l = new LongestConsecutiveSequence();
		System.out.println(l.longestConsecutive(num));
	}
}
