package cn.edu.zzti.pi.smzdm.model;

import com.alibaba.fastjson.annotation.JSONField;

public class RedirectData extends BaseModel {

    @JSONField(name = "link_type")
    private String linkType;

    @JSONField(name = "jd_isv_code")
    private String jdIsvCode;

    @JSONField(name = "sub_type")
    private String subType;

    @JSONField(name = "link")
    private String link;

    @JSONField(name = "link_title")
    private String linkTitle;

    @JSONField(name = "isv_code_second")
    private String isvCodeSecond;

    @JSONField(name = "link_val")
    private String linkVal;

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getJdIsvCode() {
        return jdIsvCode;
    }

    public void setJdIsvCode(String jdIsvCode) {
        this.jdIsvCode = jdIsvCode;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getIsvCodeSecond() {
        return isvCodeSecond;
    }

    public void setIsvCodeSecond(String isvCodeSecond) {
        this.isvCodeSecond = isvCodeSecond;
    }

    public String getLinkVal() {
        return linkVal;
    }

    public void setLinkVal(String linkVal) {
        this.linkVal = linkVal;
    }
}
