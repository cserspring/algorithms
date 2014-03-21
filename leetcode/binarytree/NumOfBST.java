package binarytree;
public class NumOfBST {
    public static int numTrees(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        int[] count = new int[n+1];
        for (int i = 0; i < n+1; ++i)
            count[i] = 0;
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        count[3] = 5;
        
        for (int i = 4; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                count[i] += count[j]*count[i-1-j];
            }
        }
        return count[n];
    }
    
    public static void main(String args[]) {
        System.out.println(numTrees(2));
    }
}