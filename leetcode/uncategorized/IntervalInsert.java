package uncategorized;

/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].*/
import java.util.ArrayList;

public class IntervalInsert {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		int i = 0;
		int n = intervals.size();
		while (i < n && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i));
			++i;
		}
		
		// Be careful here
		while (i<n && intervals.get(i).start<=newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			++i;
		}
		
		res.add(newInterval);
		while (i<n) {
			res.add(intervals.get(i));
			++i;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
