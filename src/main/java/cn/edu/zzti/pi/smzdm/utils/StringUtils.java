package cn.edu.zzti.pi.smzdm.utils;

public final class StringUtils {

    public static String underline2Camel(String source) {
        boolean upper = false;
        StringBuilder sb = new StringBuilder();
        for (char c : source.toCharArray()) {
            if ('_' == c) {
                upper = true;
                continue;
            }
            sb.append(upper ? Character.toUpperCase(c) : Character.toLowerCase(c));
            upper = false;
        }
        return sb.toString();
    }
}
