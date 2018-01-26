package cn.edu.zzti.pi.smzdm.service;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.MailModel;

/**
 * 邮件发送服务
 */
public interface MailService {

    /**
     * 发送邮件
     *
     * @param model
     * @return
     * @throws BizException
     */
    boolean sendMail(MailModel model) throws BizException;
}
