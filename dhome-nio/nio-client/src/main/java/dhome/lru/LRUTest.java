package dhome.lru;

import java.util.UUID;

public class LRUTest {

    public static void main(String[] args) throws Exception {
        int size = 1000000;
        String val;
        LRUCache<Integer, String> lru = new LRUCache<>(size);
        for (int i = 0; i < size; i++) {
            val = UUID.randomUUID().toString();
            lru.put(i, val);
        }

        Object obj = new Object();
        synchronized (obj) {
            while (true) {
                obj.wait();
            }
        }
    }

}
