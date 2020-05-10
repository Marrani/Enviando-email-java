package enviando.email;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private String userName = "gabrielmarrani@gmail.com";
	private String senha = "g8h10m97";
	
	@org.junit.Test
	public void testeEmail() {
		try {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(userName, senha);
			}		
		});
		
		
		Address [] toUser = InternetAddress.parse("sanferreira17@gmail.com, gabrielhenriquesegantini@gmail.com");
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName)); // email da pessoa que está enviando.
		msg.setRecipients(Message.RecipientType.TO, toUser); // email destinatario.
		msg.setSubject("E-mail enviado com java"); // assunto do email.
		msg.setText("Se você está recendo esse email, que dizer que deu certo sua mini apliação para  enviar email com java. Parabéns");
		
		Transport.send(msg);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
  
}
