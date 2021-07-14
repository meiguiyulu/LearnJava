import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author LYJ
 * @create 2021-07-14 16:22
 */
public class mailDemo01 {
    public static void main(String[] args) throws Exception {
        sendMail02();
    }

    public static void sendMail01() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.qq.com"); // 设置QQ邮箱服务器
        properties.setProperty("mail.transport.protocol", "smtp"); // 邮箱发送协议
        properties.setProperty("mail.smtp.auth", "true"); // 需要验证用户名、密码

        // QQ邮箱还需要设置SSL加密，其他邮箱不需要
        MailSSLSocketFactory socketFactory = new MailSSLSocketFactory();
        socketFactory.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", socketFactory);

        // 使用JavaMail发送邮件的5个步骤
        // 1、创建定义整个应用程序所需的环境信息的 Session 对象

        //QQ 才有
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                // 发件人邮箱的用户名、授权码
                return new PasswordAuthentication("1609226090@qq.com", "FAURNNDDGCPZKCLO");
            }
        });

        // 开启session的debug模式，这样可以查看程序发送Email的运行状态
        session.setDebug(true);

        // 2、通过 Session 获取transport对象
        Transport transport = session.getTransport();

        // 3、使用邮箱的用户名和授权码连接邮件服务器
        transport.connect("smtp.qq.com", "1609226090@qq.com","FAURNNDDGCPZKCLO");

        // 4、创建邮箱
        MimeMessage mimeMessage = new MimeMessage(session); // 创建邮箱对象
        mimeMessage.setFrom(new InternetAddress("1609226090@qq.com")); // 指明发件人
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("1609226090@qq.com")); // 收件人，可以与发件人相同(自己给自己发)
        mimeMessage.setSubject("只包含文本的简单邮件"); // 邮件的标题
        mimeMessage.setContent("你好呀", "text/html;charset=UTF-8");// 邮件的文本内容

        // 5、发送邮箱
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        // 关闭连接
        transport.close();
    }

    public static void sendMail02() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.qq.com"); // 设置QQ邮箱服务器
        properties.setProperty("mail.transport.protocol", "smtp"); // 邮箱发送协议
        properties.setProperty("mail.smtp.auth", "true"); // 需要验证用户名、密码

        // QQ邮箱还需要设置SSL加密，其他邮箱不需要
        MailSSLSocketFactory socketFactory = new MailSSLSocketFactory();
        socketFactory.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", socketFactory);

        // 使用JavaMail发送邮件的5个步骤
        // 1、创建定义整个应用程序所需的环境信息的 Session 对象

        //QQ 才有
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                // 发件人邮箱的用户名、授权码
                return new PasswordAuthentication("1609226090@qq.com", "FAURNNDDGCPZKCLO");
            }
        });

        // 开启session的debug模式，这样可以查看程序发送Email的运行状态
        session.setDebug(true);

        // 2、通过 Session 获取transport对象
        Transport transport = session.getTransport();

        // 3、使用邮箱的用户名和授权码连接邮件服务器
        transport.connect("smtp.qq.com", "1609226090@qq.com","FAURNNDDGCPZKCLO");

        // 4、创建邮箱
        MimeMessage mimeMessage = new MimeMessage(session); // 创建邮箱对象
        mimeMessage.setFrom(new InternetAddress("1609226090@qq.com")); // 指明发件人
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("1609226090@qq.com")); // 收件人，可以与发件人相同(自己给自己发)
        mimeMessage.setSubject("只包含文本的简单邮件"); // 邮件的标题

        /**
         * 准备图片数据
         */
        MimeBodyPart image = new MimeBodyPart();
        // 图片需要经过数据处理
        DataHandler dataHandler = new DataHandler(new FileDataSource("/src/1.png"));
        image.setDataHandler(dataHandler);  // 在我们的Body中放入这个处理的图片数据
        image.setContentID("bz.jpg"); // 给图片设置一个ID，我们在后面可以使用

        // 准备正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src='cid:bz.jpg'>的邮件", "text/html;charset=UTF-8");

        // 描述数据关系
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(text);
        multipart.addBodyPart(image);
        multipart.setSubType("related");

        // 设置到消息中, 保存修改
        mimeMessage.setContent(multipart); // 把最后编辑好的邮件放到消息中
        mimeMessage.saveChanges(); // 保存修改

        // 5、发送邮箱
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        // 关闭连接
        transport.close();
    }
}
