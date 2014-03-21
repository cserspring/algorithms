package uncategorized;

/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

   Note:
   Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * */
public class SingleNumber {
	public static int singleNumber(int[] A) {
		int single = 0;
		for (int i = 0; i < 32; ++i) {
			int bits = 0;
			for (int j = 0; j < A.length; ++j) {
				bits = (bits+(A[j]&1))%3;
				A[j] >>= 1;
			}
			single += (1<<i)*bits;
		}
		return single;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5,5,5,6, 8,8,8};
		System.out.println(singleNumber(A));
	}

}
