package arr;

public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
        int start = -1;
        int n = A.length;
        for (int i = 0; i < n; ++i) {
        	if (A[i] != elem) {
        		++start;
        		A[start] = A[i];
        	}
        }
        return start + 1;
    }
	public static void main(String[] args) {
		int[] A = {1,1,3,43,23,1};
		System.out.println(removeElement(A, 1));
	}

}
