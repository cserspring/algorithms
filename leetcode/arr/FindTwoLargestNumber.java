package arr;

public class FindTwoLargestNumber {
	public static int[] find(int[] num) {
		if (num.length < 2)
			return null;
		int[] res = new int[2];
		res[0] = Integer.MIN_VALUE;
		res[1] = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; ++i) {
			if (num[i] > res[0]) {
				res[1] = res[0];
				res[0] = num[i];
			} else if (num[i] > res[1])
				res[1] = num[i];
		}
		return res;
	}

	public static void main(String args[]) {
		int[] num = { 4, 3, 6, 1, 9 };
		System.out.println(find(num)[0]);
		System.out.println(find(num)[1]);
	}
}