public class SortColor {
    public static void sortColors(int[] A) {
        if (A == null || A.length == 0)
            return;
        int p0 = 0;
        int p1 = 0;
        int p2 = A.length - 1;
        
        /*
         * p0指向0该呆的位置
         * p2指向2该呆的位置
         * 然后p1开始走动,遇到0就交换,p0++, p1++
         * 遇到2也交换,p2--,但p1不动，因为交换过来的的有可能是0，所以按兵不动
         * */
        while (p1 <= p2) {
            if (A[p1] == 0) {
                swap(A, p1, p0);
                ++p0;
                ++p1;
            } else if (A[p1] == 2) {
                swap(A, p1, p2);
                --p2;
            } else {
                ++p1;
            }
        }
    }
    
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = {0,1,2,2,1,0,2,1,0};
        sortColors(num);
        for (int i = 0; i < num.length; ++i)
            System.out.println(num[i]);
        
    }

}
