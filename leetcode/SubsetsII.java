package leetcode;
/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,2], a solution is:
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubsetsII {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num==null)
        	return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        set.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length;++i) {
        	//int j = set.size();
        	HashSet<ArrayList<Integer>> newSet = new HashSet<ArrayList<Integer>>(set);
        	for(ArrayList<Integer> one : newSet) {
        		ArrayList<Integer> newResult = new ArrayList<Integer>(one);
        		newResult.add(num[i]);
        		set.add(newResult);
        	}
        }
        return new ArrayList<ArrayList<Integer>>(set);
	}
	
	public static ArrayList<ArrayList<Integer>> subsetsWithDupII(int[] num) {
		Arrays.sort(num);
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	    ret.add(new ArrayList<Integer>());

	    int start = 0;
	    for(int i = 0; i < num.length; i++)
	    {
	        int size = ret.size();
	        for(int j = start; j < size; j++)
	        {
	            ArrayList<Integer> sub = new ArrayList<Integer>(ret.get(j));
	            sub.add(num[i]);
	            ret.add(sub);
	        }
	        if(i < num.length - 1 && num[i + 1] == num[i])
	            start = size;
	        else
	            start = 0;
	    }

	    return ret;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,2};
		System.out.println(subsetsWithDup(num));
	}

}
