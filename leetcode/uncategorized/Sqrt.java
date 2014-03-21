package uncategorized;

public class Sqrt {
	public int sqrt(int x) {
		if (x == 0)
			return 0;
		if (x <= 3)
			return 1;
		int mid = Math.min(x/2, (int)Math.sqrt((double)Integer.MAX_VALUE));
		return binarySearch(x, 2, mid);
	}

	private int binarySearch(int target, int start, int end) {
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (square(mid) == target)
				return mid;
			else if (square(mid) < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return end;
	}

	private int square(int y) {
		return y * y;
	}

	public static void main(String args[]) {
		Sqrt s = new Sqrt();
		for (int i = 0; i < 18; ++i)
			System.out.println(i + ": " + s.sqrt(i));
	}
}
