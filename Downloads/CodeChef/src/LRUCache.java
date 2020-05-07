import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer,Integer> hashMap;
    int first_key;
    public LRUCache(int capacity) {
    this.capacity = capacity;
        hashMap=new LinkedHashMap<>();
        first_key = -1;
    }

    public int get(int key) {
        return 0;
    }

    public void set(int key, int value) {
        if(hashMap.size() == this.capacity){
          // hashMap
        }
    }
}
