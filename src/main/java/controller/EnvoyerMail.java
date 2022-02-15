package controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvoyerMail {
	/*
	 * https://www.google.com/settings/security/lesssecureapps 
	 * reduit la securite du compte
	 */
	
	/*
	 * https://www.codejava.net/java-ee/jsp/sending-e-mail-with-jsp-servlet-and-javamail
	 * https://www.tutorialspoint.com/servlets/servlets-sending-email.htm
	 */

	public static void sendEmail(String host, String port,
			final String userName, final String password, String toAddress) throws AddressException,
			MessagingException {
		
		UserDaoProj ud = new UserDaoProj();
		
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//properties.put("mail.smtp.ssl.trust", "host-url");
		//erreur convert tls , ne pas oublier le javax.mail et javax.activation
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = {
				//adresse de l'utilisateur
			new InternetAddress(toAddress)
		};
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject("Changement de mot de passe");
		msg.setSentDate(new Date());
		msg.setText("Bonjour, \n voici le lien pour changer votre mot de passe.\n"
			+"http://localhost:8080/projectStat/editPassword?id="+ud.idByEmail(toAddress));

		// sends the e-mail
		Transport.send(msg);

	}
	
}
