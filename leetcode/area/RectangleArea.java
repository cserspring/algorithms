package area;
/**
 * The input is many rectangles.
 * We use hashmap to get the covered area, we can even calculate the 
 * areas which have been covered 2 or 3 times.
 * */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RectangleArea {
    public static final int n = 4;

    static class Pair {
        public int x1;
        public int y1;
        public int x2;
        public int y2;

        public Pair(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Pair))
                return false;
            Pair p = (Pair) o;
            return (p.x1 == this.x1 && p.x2 == this.x2 && p.y1 == this.y1 && p.y2 == this.y2);
        }
        @Override
        public int hashCode() {
            int result = 17;
            result = 31*result + x1;
            result = 31*result + y1;
            result = 31*result + x2;
            result = 31*result + y2;
            return result;
        }
    }

    public static int area(int[][] rectanges, int m) {
        HashMap<Pair, Integer> covers = new HashMap<Pair, Integer>();
        int[] x = new int[2 * m];
        int[] y = new int[2 * m];
        int area = 0;
        int count = 0;
        for (int i = 0; i < m; ++i) {
            x[count] = rectanges[i][0];
            x[count + 1] = rectanges[i][2];
            y[count] = rectanges[i][1];
            y[count + 1] = rectanges[i][3];
            count += 2;
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < m; ++i) {
            int x1 = Arrays.binarySearch(x, rectanges[i][0]);
            int y1 = Arrays.binarySearch(y, rectanges[i][1]);
            int x2 = Arrays.binarySearch(x, rectanges[i][2]);
            int y2 = Arrays.binarySearch(y, rectanges[i][3]);

            for (int j = x1; j < x2; ++j) {
                for (int k = y1; k < y2; ++k) {
                    Pair p = new Pair(j, k, j + 1, k + 1);
                    if (!covers.containsKey(p))
                        covers.put(p, 1);
                    else
                        covers.put(p, covers.get(p) + 1);
                }
            }
        }
        for (Map.Entry<Pair, Integer> e : covers.entrySet()) {
            area += (x[e.getKey().x2] - x[e.getKey().x1])
                    * (y[e.getKey().y2] - y[e.getKey().y1]);
        }
        return area;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] rectangles = { { 2, 2, 4, 4 }, { 1, 1, 3, 3 }, { 0, 0, 2, 2 }, {3,2, 1000, 3} };
        System.out.println(area(rectangles, rectangles.length));
    }

}
