package mailpackege;


import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by hanyan on 2017/8/13.
 */
public class MailTest {
    public static void main(String[] args)throws Exception{
        Properties properties=new Properties();
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.transport.protocol","smtp");
        Session session=Session.getInstance(properties);
        session.setDebug(true);
        Message msg=new MimeMessage(session);
        msg.setText("hhhhhhh");
        msg.setFrom(new InternetAddress("zjzyydxhan@163.com"));
        Transport transport=session.getTransport();

        transport.connect("smtp.163.com",25,"zjzyydxhan","4207938231abc");
        transport.sendMessage(msg,new Address[]{new InternetAddress("1451231593@qq.com")});
        transport.close();
    }


}
