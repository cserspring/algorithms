package arr;

public class RemoveDuplicatesfromSortedArrayII {
	public static int removeDuplicates(int[] A) {
		int n = A.length;
		if (n < 3)
			return n;
		int cur = 1;
		for (int i = 2; i < n; ++i) {
			if (!(A[i] == A[cur] && A[i] == A[cur-1])) {
				A[++cur] = A[i];
			}
		}
		return cur + 1;
	}
	
	public static int removeDuplicatesII(int[] A) {
        int n = A.length;
        if (n<3)
        	return n;
        int start = -1;
        int dupcount = 1;
        for (int i = 1; i <= n; ++i) {
        	if (i != n && A[i]==A[i-1]) {
        		++dupcount;
        	} else {
        		if (dupcount >= 2) {
        			A[++start] = A[i-1];
        			A[++start] = A[i-1];
        			dupcount = 1;
        		} else {
        			A[++start] = A[i-1];
        		}
        	}
        }
        return start + 1;
    }
	
	public static void main(String args[]) {
		int[] A = {1,1,1,5, 3,3,4,4,4};
		System.out.println(removeDuplicates(A));
	}
}
