package cn.edu.zzti.pi.smzdm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static Date getNow() {
        return new Date();
    }

    public static Long getTimestamp() {
        return getTimestamp(getNow());
    }

    public static Long getTimestamp(Date date) {
        return date.getTime();
    }

    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    public static int getCurrentHour() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static boolean currentHourInRange(Integer startHour, Integer endHour) {
        if (null == startHour || null == endHour) return false;
        return startHour <= getCurrentHour() && getCurrentHour() <= endHour;
    }
}
