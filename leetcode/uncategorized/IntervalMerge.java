package uncategorized;

/*
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval /*implements Comparable<Interval>*/{
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

//	@Override
//	public int compareTo(Interval arg0) {
//		return this.start-arg0.start;
//	}
}

public class IntervalMerge {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size()==0)
			return res;
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval arg0, Interval arg1) {
				return arg0.start-arg1.start;
			}
			
		});
		Interval prev = intervals.get(0);
		res.add(prev);
		for (int i = 1; i < intervals.size(); ++i) {
			Interval cur = intervals.get(i);
			if (res.get(res.size()-1).end >= cur.start && res.get(res.size()-1).end<= cur.end) {
				res.get(res.size()-1).end = cur.end;
			} else if (res.get(res.size()-1).end >= cur.start && res.get(res.size()-1).end > cur.end) {
				
			}else {
				res.add(cur);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
