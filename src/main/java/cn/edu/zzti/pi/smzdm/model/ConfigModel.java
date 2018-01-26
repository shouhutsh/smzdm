package cn.edu.zzti.pi.smzdm.model;

import java.util.List;

public class ConfigModel extends BaseModel {

    private String email;
    private List<String> filters;
    private Integer enableStartHour = 7;
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
