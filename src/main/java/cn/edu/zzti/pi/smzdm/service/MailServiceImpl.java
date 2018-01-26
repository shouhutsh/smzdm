package cn.edu.zzti.pi.smzdm.service;

import cn.edu.zzti.pi.smzdm.exception.BizException;
import cn.edu.zzti.pi.smzdm.model.MailModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean sendMail(MailModel model) throws BizException {
        logger.info("收到发送邮件请求");
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(model.getFrom());
            helper.setTo(model.getTo());
            helper.setSubject(model.getSubject());
            helper.setText(model.getText(), true);

            for (Map.Entry<String, File> e : model.getAttachments().entrySet()) {
                helper.addAttachment(e.getKey(), e.getValue());
            }
            for (Map.Entry<String, File> e : model.getInlineFiles().entrySet()) {
                helper.addInline(e.getKey(), e.getValue());
            }
            mailSender.send(message);
            logger.info("邮件发送成功！");
            return true;
        } catch (MessagingException e) {
            logger.error("邮件发送失败！", e);
            return false;
        }
    }
}
