package design;
//http://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheII {
    private LinkedHashMap<Integer, Integer> cache;
    private int cap;
    
    public LRUCacheII(int capacity) {
        cap = capacity;
        // access-order
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            private static final long serialVersionUID = 1L;

            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cap;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }
}
