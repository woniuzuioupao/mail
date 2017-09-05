package mailpackege;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by hanyan on 2017/8/14.
 */
public class MailTest2 {
    public static void main(String[]args)throws Exception{
        Properties props=new Properties();
        props.setProperty("mail.smtp.auth","true");
        props.setProperty("mail.transport.protocol","smtp");
        props.setProperty("mail.host","smtp.163.com");
        props.setProperty("mail.post","25");
        Session session=Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("zjzyydxhan","4207938231abc");
                    }
                }
        );
        session.setDebug(true);

        Message message=new MimeMessage(session);
        message.setFrom(new InternetAddress("zjzyydxhan@163.com"));
        //message.setContent("ninaadfadsfdsfsd","charset=utf8");
        //message.setContent("<span style=\"color:red\">中文哈哈哈</span>","text/html;charset=utf8");
        message.setSubject("test");
        message.setText("我是妈妈");
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1451231593@qq.com"));


        Transport.send(message);
    }
}
