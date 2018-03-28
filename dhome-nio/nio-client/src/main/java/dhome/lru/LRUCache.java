package dhome.lru;

import java.util.HashMap;

public class LRUCache<K, V> {
    private final int                          MAX_CACHE_SIZE;
    private LRUNode<K, V>                      head;
    private LRUNode<K, V>                      tail;

    private volatile HashMap<K, LRUNode<K, V>> hashMap = null;

    public LRUCache(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<>(MAX_CACHE_SIZE);
    }

    public synchronized void put(K key, V value) {
        LRUNode<K, V> node = getNode(key);
        if (null == node) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                removeLast();
            }
            node = new LRUNode<K, V>(key, value);
        }
        moveToFirst(node);
        hashMap.put(key, node);
    }

    public synchronized V get(K key) {
        LRUNode<K, V> node = getNode(key);
        if (null == node)
            return null;
        moveToFirst(node);

        return node.getValue();
    }

    public synchronized void clear() {
        if (null != hashMap)
            hashMap.clear();

        head = null;
        tail = null;
    }

    public synchronized void remove(K key) {
        LRUNode<K, V> node = getNode(key);
        if (null == node)
            return;

        if (null != node.prev)
            node.prev.next = node.next;
        if (null != node.next)
            node.next.prev = node.prev;
        if (head == node)
            head = node.next;
        if (tail == node)
            tail = node.prev;

        hashMap.remove(key);
    }

    private LRUNode<K, V> getNode(K key) {
        return hashMap.get(key);
    }

    private void moveToFirst(LRUNode<K, V> node) {
        if (null == node)
            return;

        if (head == null && tail == null) {
            head = tail = node;
            return;
        }

        if (null != node.prev)
            node.prev.next = node.next;
        if (null != node.next)
            node.next.prev = node.prev;
        if (tail == node)
            tail = node.prev;

        node.next = head;
        head.prev = node;
        head = node;
        node.prev = null;
    }

    private void removeLast() {
        if (null == tail)
            return;

        hashMap.remove(tail.getKey());

        tail = tail.prev;
        if (null == tail)
            head = null;
        else
            tail.next = null;
    }
}
