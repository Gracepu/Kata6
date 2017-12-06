package kata6.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {
    private final Map<T,Integer> map = new HashMap<>();
    
    public void increment (T key) {
        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
    }
    
    public Set<T> keySet() {
        return map.keySet();
    }
    
    public Integer getKey(T key) {
        return map.get(key);
    }
}
