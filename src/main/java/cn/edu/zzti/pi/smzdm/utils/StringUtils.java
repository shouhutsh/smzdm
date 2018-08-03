package cn.edu.zzti.pi.smzdm.utils;

public final class StringUtils {

    public static boolean isEmpty(String str) {
        return null == str || str.length() == 0;
    }

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

    /**
     * 简单将类似 1.2K -> 1200
     * @param num
     * @return
     */
    public static Integer parse2Integer(String num) {
        if (null == num || num.length() <= 0) return null;

        int len = num.length();
        char end = num.charAt(len - 1);
        if (isDigit(end)) {
            return Integer.valueOf(num);
        } else {
            String n = num.substring(0, len - 1);
            Double d = Double.valueOf(n);
            return (int) (d * unit2Int(end));
        }
    }

    /**
     * 简单将单位转成相应倍数，解析失败返回 1
     *      K -> 1000
     *      M -> 1000 * 1000
     *      G -> 1000 * 1000 * 1000
     * @param unit
     * @return
     */
    private static int unit2Int(char unit) {
        char ch = Character.toUpperCase(unit);
        int i = 1;
        switch (ch) {
            case 'G': i *= 1000;
            case 'M': i *= 1000;
            case 'K': i *= 1000;

            break;
            default: return 0;
        }
        return i;
    }

    private static boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public static void main(String[] args) {
        System.out.println(parse2Integer("1.2K"));
    }
}
