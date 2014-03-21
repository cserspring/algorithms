package uncategorized;
/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

   Your algorithm's runtime complexity must be in the order of O(log n).

   If the target is not found in the array, return [-1, -1].

   For example,
   Given [5, 7, 7, 8, 8, 10] and target value 8,
   return [3, 4].
 * */
public class SearchforRange {
	public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
        int len = A.length;
        int left = 0;
        int right = len-1;
        int index = -1;
        while (left <= right) {
        	int mid = left+right;
        	if (A[mid] == target) {
        		index = mid;
        		break;
        	} else if (A[mid] > target) {
        		right = mid-1;
        	} else {
        		left = mid+1;
        	}
        }
        if (index !=-1) {
        	res[0] = index;
        	res[1] = index;
        	while (res[0]>0 && A[res[0]+1] == A[index])
        		res[0]--;
        	while(res[1]<len-1 && A[res[1]-1]==A[index])
        		res[1]++;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
