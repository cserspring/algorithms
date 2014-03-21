package integer;

public class ReverseInteger {
	public static int reverse(int x) {
		int res = 0;
		while (x != 0) {
			res = res*10 + x%10;
			x = x/10;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-123));
	}

}
