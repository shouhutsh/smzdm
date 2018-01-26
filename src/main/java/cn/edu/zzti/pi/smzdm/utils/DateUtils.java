package cn.edu.zzti.pi.smzdm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 获取当前时间
     * @return
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public static Long getTimestamp() {
        return getTimestamp(getNow());
    }

    /**
     * 根据送入Date获取时间戳
     * @param date
     * @return
     */
    public static Long getTimestamp(Date date) {
        return date.getTime();
    }

    /**
     * 为 Date 增加/减少天数
     * @param date
     * @param n
     * @return
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 获取当前小时数
     * @return
     */
    public static int getCurrentHour() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 判断当前小时数是否在送入区间中
     * @param startHour
     * @param endHour
     * @return
     */
    public static boolean currentHourInRange(Integer startHour, Integer endHour) {
        if (null == startHour || null == endHour) return false;
        return startHour <= getCurrentHour() && getCurrentHour() <= endHour;
    }
}
