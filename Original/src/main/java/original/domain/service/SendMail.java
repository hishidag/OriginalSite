package original.domain.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 
 * メールを送信するサービス
 * sendMailの引数に名前、題名、本文を渡すと名前：題名を題名としたメールが届く
 *
 */
@Component
public class SendMail {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendMail(String name,String subject,String text) throws MessagingException{
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper msg = new MimeMessageHelper(message,true);
		
		msg.setFrom("hishidag@gmail.com");
		msg.setTo("hishidag@gmail.com");
		msg.setSubject(name +"さまからのお問い合わせ：：件名："+ subject);
		msg.setText(text,true);
		
		this.sender.send(message);
	}
}
