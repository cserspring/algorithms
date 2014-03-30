package uncategorized;

import java.util.ArrayList;

public class GrayCode {
	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
        if (n < 0) {
        
        	return res;
        }
        res.add(0);
        //res.add(1);
        int count = 0;
        while (count < n) {
        	int size = res.size();
        	for (int i = size - 1; i >= 0; --i) {
        		res.add(res.get(i) + (1 << count));
        	}
        	++count;
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.println(grayCode(0));
	}
}
