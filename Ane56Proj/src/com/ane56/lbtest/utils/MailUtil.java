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
			signature = "�Զ�������С��";
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * �����ʼ�
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
			// ����Properties����
			Properties props = System.getProperties();
			// �����ż�������
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true"); // ͨ����֤
			// �õ�Ĭ�ϵĶԻ�����
			Session session = Session.getDefaultInstance(props, null);
			// ����һ����Ϣ������ʼ������Ϣ�ĸ���Ԫ��
			MimeMessage msg = new MimeMessage(session);
			signature = MimeUtility.encodeText(signature);
			msg.setFrom(new InternetAddress(signature + "<" + from + ">"));
			// �����ռ����б�
			if (!toList.isEmpty())
			{
				int receiverCount = toList.size();
				InternetAddress[] address = new InternetAddress[receiverCount];
				for (int i = 0; i < receiverCount; i++)
					address[i] = new InternetAddress(toList.get(i));
				msg.addRecipients(Message.RecipientType.TO, address);
				msg.setSubject(subject);
				// �����BodyPart�����뵽�˴�������Multipart��
				Multipart mp = new MimeMultipart();
				// ��������
				if (!filepath.isEmpty())
				{
					for (String filename : filepath)
					{
						MimeBodyPart mbp = new MimeBodyPart();
						// �õ�����Դ
						FileDataSource fds = new FileDataSource(filename);
						// �õ�������������BodyPart
						mbp.setDataHandler(new DataHandler(fds));
						// �õ��ļ���ͬ������BodyPart
						mbp.setFileName(fds.getName());
						mp.addBodyPart(mbp);
					}
					MimeBodyPart mbp = new MimeBodyPart();
					mbp.setContent(body, "text/html;charset=UTF-8");
					mp.addBodyPart(mbp);
					// Multipart���뵽�ż�
					msg.setContent(mp);
				} else
					// �����ʼ�����
					msg.setText(body);
				// �����ż�ͷ�ķ�������
				msg.setSentDate(new Date());
				msg.saveChanges();
				// �����ż�
				Transport transport = session.getTransport("smtp");
				transport.connect(host, username, password);
				transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
				transport.close();
				logger.info("�ʼ����ͳɹ�");
			} else
				throw new RuntimeException("�ռ���Ϊ��");
		} catch (Exception e)
		{
			logger.info("�ʼ�����ʧ��");
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String reportPath = System.getProperty("user.dir") + "/HtmlReport/" + date;
		String subject = date + "³��ϵͳ�Զ������Ա���";
		String body = "<font color=black size=5 face=calibri>Dear All:</font><br><br>"
				+ "<font color=black size=4 face=΢���ź�>" + "&emsp;&emsp;" + date + "³��ϵͳ�Զ�����������ɣ����������������</font>";
		List<String> filepath = new ArrayList<>();
		filepath.add(reportPath + ".zip");
		ZipUtil.compress(reportPath);
		MailUtil.sendMail(subject, body, filepath);
		System.out.println("Success...");
	}
}