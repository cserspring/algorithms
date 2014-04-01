package uncategorized;

public class Pow {
	public static double pow(double x, int n) {
		if (n==0)
			return 1.0;
		double half = pow(x, n/2);
		if (n%2 == 0) return half * half;
		if (n > 0) return half * half * x;
		if (n < 0) return half * half / x;
		return 0.0;
	}
	public static double powII(double x, int n) {
		double result = 1.0;
        int nn = Math.abs(n);
        for (int i = 1; i <=nn;++i) {
        	result *= x;
        }
        if (n>=0)
        	return result;
        else 
        	return 1/result;
    }
	public static void main(String[] args) {
		System.out.println(pow(-3,-3));
	}

}
