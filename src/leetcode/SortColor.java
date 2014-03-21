package leetcode;
public class SortColor {
    public static void sortColors(int[] A) {
        if (A == null || A.length == 0)
            return;
        int p0 = 0;
        int p1 = 0;
        int p2 = A.length - 1;
        
        /*
         * p0鎸囧悜0璇ュ憜鐨勪綅缃�
         * p2鎸囧悜2璇ュ憜鐨勪綅缃�
         * 鐒跺悗p1寮�璧板姩,閬囧埌0灏变氦鎹�p0++, p1++
         * 閬囧埌2涔熶氦鎹�p2--,浣唒1涓嶅姩锛屽洜涓轰氦鎹㈣繃鏉ョ殑鐨勬湁鍙兘鏄�锛屾墍浠ユ寜鍏典笉鍔�
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
