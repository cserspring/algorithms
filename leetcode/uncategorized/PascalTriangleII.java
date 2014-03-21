package uncategorized;

import java.util.ArrayList;

public class PascalTriangleII {
	public static ArrayList<Integer> getRow(int rowIndex) {
		if (rowIndex < 0)
			return null;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for (int i = 1; i < rowIndex + 1; ++i) {
        	res.add(0);
        }
        for (int i = 1; i < rowIndex + 1; ++i) {
        	// 这里反着来,可以用11生成121来进行对比
        	for (int j = i; j > 0; --j) {
        		res.set(j, res.get(j)+res.get(j-1));
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(0));
	}

}
