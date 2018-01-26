package cn.edu.zzti.pi.smzdm.model;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 邮件模型
 */
public class MailModel extends BaseModel {

    /**
     * 发送人
     */
    private String from;
    /**
     * 收件人列表
     */
    private String[] to;
    /**
     * 主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String text;

    /**
     * 附件列表
     */
    private final Map<String, File> attachments = new LinkedHashMap<>();
    /**
     * 内联附件列表
     */
    private final Map<String, File> inlineFiles = new LinkedHashMap<>();

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, File> getAttachments() {
        return attachments;
    }

    public Map<String, File> getInlineFiles() {
        return inlineFiles;
    }
}
