package cn.edu.zzti.pi.smzdm.model;

import java.util.List;

/**
 * 用户配置模型
 */
public class ConfigModel extends BaseModel {

    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户配置过滤器列表
     */
    private List<String> filters;
    /**
     * 用户设置开启发送通知的小时
     */
    private Integer enableStartHour = 7;
    /**
     * 用户设置关闭发送通知的小时
     */
    private Integer enableEndHour = 22;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public Integer getEnableStartHour() {
        return enableStartHour;
    }

    public void setEnableStartHour(Integer enableStartHour) {
        this.enableStartHour = enableStartHour;
    }

    public Integer getEnableEndHour() {
        return enableEndHour;
    }

    public void setEnableEndHour(Integer enableEndHour) {
        this.enableEndHour = enableEndHour;
    }
}
