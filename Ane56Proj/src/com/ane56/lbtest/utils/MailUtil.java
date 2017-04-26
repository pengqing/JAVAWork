package com.ane56.lbtest.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

public class MailUtil
{
	private final static Logger logger = Logger.getLogger(ZipUtil.class);
	private static String host;
	private static String username;
	private static String password;
	private static String from;
	private static String signature;

	static
	{
		try
		{
			host = "smtp.139.com";
			username = "18512197543";
			password = "wh715000";
			from = "18512197543@139.com";
			signature = "自动化测试小组";
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @author WangHui
	 * @param subject
	 * @param body
	 * @param filepath
	 */
	public static void sendMail(String subject, String body, List<String> filepath)
	{
		Object[][] contacts = XmlUtil.readXml("MailReciever", "LuBanProject");
		ArrayList<String> toList = new ArrayList<>();
		for (int m = 0; m < contacts.length; m++)
			for (int n = 0; n < contacts[m].length; n++)
				toList.add(contacts[m][n].toString());
		try
		{
			// 创建Properties对象
			Properties props = System.getProperties();
			// 创建信件服务器
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true"); // 通过验证
			// 得到默认的对话对象
			Session session = Session.getDefaultInstance(props, null);
			// 创建一个消息，并初始化该消息的各项元素
			MimeMessage msg = new MimeMessage(session);
			signature = MimeUtility.encodeText(signature);
			msg.setFrom(new InternetAddress(signature + "<" + from + ">"));
			// 创建收件人列表
			if (!toList.isEmpty())
			{
				int receiverCount = toList.size();
				InternetAddress[] address = new InternetAddress[receiverCount];
				for (int i = 0; i < receiverCount; i++)
					address[i] = new InternetAddress(toList.get(i));
				msg.addRecipients(Message.RecipientType.TO, address);
				msg.setSubject(subject);
				// 后面的BodyPart将加入到此处创建的Multipart中
				Multipart mp = new MimeMultipart();
				// 附件操作
				if (!filepath.isEmpty())
				{
					for (String filename : filepath)
					{
						MimeBodyPart mbp = new MimeBodyPart();
						// 得到数据源
						FileDataSource fds = new FileDataSource(filename);
						// 得到附件本身并至入BodyPart
						mbp.setDataHandler(new DataHandler(fds));
						// 得到文件名同样至入BodyPart
						mbp.setFileName(fds.getName());
						mp.addBodyPart(mbp);
					}
					MimeBodyPart mbp = new MimeBodyPart();
					mbp.setContent(body, "text/html;charset=UTF-8");
					mp.addBodyPart(mbp);
					// Multipart加入到信件
					msg.setContent(mp);
				} else
					// 设置邮件正文
					msg.setText(body);
				// 设置信件头的发送日期
				msg.setSentDate(new Date());
				msg.saveChanges();
				// 发送信件
				Transport transport = session.getTransport("smtp");
				transport.connect(host, username, password);
				transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
				transport.close();
				logger.info("邮件发送成功");
			} else
				throw new RuntimeException("收件人为空");
		} catch (Exception e)
		{
			logger.info("邮件发送失败");
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String reportPath = System.getProperty("user.dir") + "/HtmlReport/" + date;
		String subject = date + "鲁班系统自动化测试报告";
		String body = "<font color=black size=5 face=calibri>Dear All:</font><br><br>"
				+ "<font color=black size=4 face=微软雅黑>" + "&emsp;&emsp;" + date + "鲁班系统自动化测试已完成，报告详情见附件！</font>";
		List<String> filepath = new ArrayList<>();
		filepath.add(reportPath + ".zip");
		ZipUtil.compress(reportPath);
		MailUtil.sendMail(subject, body, filepath);
		System.out.println("Success...");
	}
}