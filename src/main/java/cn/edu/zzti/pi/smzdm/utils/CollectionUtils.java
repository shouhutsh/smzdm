package cn.edu.zzti.pi.smzdm.utils;

import java.util.*;

public final class CollectionUtils {

    public static <K, V> boolean put(Map<K, List<V>> map, K key, V value) {
        List<V> l = map.get(key);
        if (null == l) {
            l = new ArrayList<>();
            map.put(key, l);
        }
        return l.add(value);
    }

    public static <T> List<T> unique(List<T> list, Comparator<T> comparator) {
        TreeSet<T> set = new TreeSet<>(comparator);
        set.addAll(list);
        return new ArrayList<>(set);
    }
}
