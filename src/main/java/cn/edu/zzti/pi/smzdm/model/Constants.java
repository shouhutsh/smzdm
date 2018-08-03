package cn.edu.zzti.pi.smzdm.model;

public final class Constants {
    private Constants() {}

    /**
     * SMZDM 数据列表接口，timesort 类时间戳（timestamp / 10）
     */
    public static final String ARTICLES_URL = "https://m.smzdm.com/ajax_home_list_show?timesort=%s";

    public static final String SMZDM_URL = "https://zhiyou.smzdm.com";
    public static final String LOGIN_URL = "https://zhiyou.smzdm.com/user/login/ajax_check";
    public static final String CHECKIN_URL = "https://zhiyou.smzdm.com/user/checkin/jsonp_checkin";

    public static final int TASK_SMZDM_CRAWL_FIXED_RATE = 60 * 60 * 1000;
    public static final int TASK_SMZDM_CHECKIN_FIXED_RATE = 8 * 60 * 60 * 1000;
}
