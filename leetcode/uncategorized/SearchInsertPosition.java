package uncategorized;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        if (A==null || A.length==0)
        	return 0;
        int n = A.length;
        int index=-1;
        int left = 0;
        int right = n-1;
        while (left <= right) {
        	int mid = (left+right)/2;
        	if (A[mid]==target) {
        		index = mid;
        		break;
        	} else if (A[mid] > target) {
        		right = mid-1;
        	} else {
        		left = mid+1;
        	}
        }
        
        if (index ==-1)
        	index = right+1;
        return index;
    }
}
