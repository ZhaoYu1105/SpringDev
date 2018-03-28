package dhome.lru;

import java.util.Objects;

public class LRUNode<K, V> {
    private K         key;
    private V         value;

    public LRUNode<K, V> prev;
    public LRUNode<K, V> next;

    public LRUNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj instanceof LRUNode) {
            LRUNode<?, ?> n = (LRUNode<?, ?>) obj;
            if (Objects.equals(this.key, n.getKey()) && Objects.equals(this.value, n.getValue()))
                return true;
        }

        return false;
    }

    @Override
    public final String toString() {
        return key + "=" + value;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }
}
