package uncategorized;
/* Given n points on a 2D plane, find the maximum number
 *  of points that lie on the same straight line.*/
import java.util.HashMap;
import java.util.Map;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPointsinLiine {
	public static int maxPoints(Point[] points) {
		if (points == null || points.length==0)
			return 0;
		int n = points.length;
		if (n==1)
			return 1;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int max=0;
		
		for (int i = 0; i < n-1; ++i) {
			Point p0 = points[i];
			
			int dup = 0;
			map.clear();
			int ret = 0;
			for (int j = i+1; j < n; ++j) {
				double slope = Double.MAX_VALUE;
				Point p1 = points[j];
				if (p0.x != p1.x) {
					slope = (double)(p1.y-p0.y)/(p1.x-p0.x);
					if (slope==-0.0)
						slope = Math.abs(slope);
				} else if (p0.y == p1.y) {
					dup++;
					continue;
				}
				map.put(slope, map.containsKey(slope) ? (map.get(slope)+1) : 1);
			}
			
			for (Map.Entry<Double, Integer> entry : map.entrySet()) {
				int tmp = entry.getValue();
				if (tmp > ret)
					ret = tmp;
			}
			ret+=dup;
			max = Math.max(max, ret);
		}
		return max+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub(-4,-4),(-8,-582),(-3,3),(-9,-651),(9,591)
		// 
		Point[] points = {new Point(-4,-4),new Point(-8,-582),new Point(-9,-651),new Point(9,591)};
		System.out.println(maxPoints(points));
	}

}
