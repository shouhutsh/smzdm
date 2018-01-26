package cn.edu.zzti.pi.smzdm.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MapUtils {

    public static <K, V> boolean put(Map<K, List<V>> map, K key, V value) {
        List<V> l = map.get(key);
        if (null == l) {
            l = new ArrayList<>();
            map.put(key, l);
        }
        return l.add(value);
    }
}
