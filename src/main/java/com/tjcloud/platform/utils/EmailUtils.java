package com.tjcloud.platform.utils;

import com.tjcloud.exception.CommonException;
import com.tjcloud.exception.ExceptionCode;
import com.tjcloud.platform.constant.Constant;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

    private HtmlEmail email;

    @Async
    public void sendEmailTo(String to, String msg) throws EmailException {

        email = new HtmlEmail();
        email.setHostName("smtp.exmail.qq.com");
        email.setSmtpPort(465);
        email.setCharset("UTF-8");
        email.setAuthenticator(new DefaultAuthenticator("support@tianjiancloud.com", "9dCiER56"));
        email.setSSLOnConnect(true);
        email.setFrom("support@tianjiancloud.com");
        email.setSubject("我要运动 验证邮件");
        email.setHtmlMsg(msg);
        email.addTo(to);
        email.send();
    }

    public static void ValidEmailPattenValidate(String email) {
        if (!Constant.mailPattern.matcher(email).matches()) {
            throw new CommonException(ExceptionCode.INVALID_EMAIL.getCode());
        }
    }
}
