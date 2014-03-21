package uncategorized;

/* Divide two integers without using multiplication, division and mod operator. */
public class DivideTwoIntegers {
	// Will be TLE when Integer.MAX_VALUE/1
	public int divideII(int dividend, int divisor) {
        int count = 0;
        int sum = 0;
        boolean flag = false;
        if ((dividend >0 && divisor <0) || (dividend <0 && divisor >0))
            flag = true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (sum <= dividend) {
            sum += divisor;
            ++count;
        }
        if (flag)
            return 1-count;
        return count-1;
    }
	
	public static int divide(int dividend, int divisor) {
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		int count = 0;
		
		while (a >= b) {
			long c = b;
			for (int i = 0; a>=c;++i, c = c<<1) {
				a = a-c;
				count+=1<<i;
			}
		}
		return ((dividend ^ divisor)>>31 == 0) ? count:-count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648, 1));
	}

}
