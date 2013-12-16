package kiwistrongis.ss;

//standard library imports
import java.util.Properties;

//javax.mail imports
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Message;
import javax.mail.MessagingException;

public class Mailer {
	private Session session;
	private static final String host = "localhost";
	private static final String from = "santa@north.pole";
	private static final String subject =
		"Your Secret Santa Assignment!";

	public Mailer(){
		//setup mail server
		Properties properties = System.getProperties();
		properties.setProperty( "mail.smtp.host", host);
		session = Session.getDefaultInstance( properties);}

	public void send( String to, String text)
			throws MessagingException {
		//setup the message
		MimeMessage message = new MimeMessage( session);
		message.setFrom( new InternetAddress( from));
		message.addRecipient(
			Message.RecipientType.TO, new InternetAddress( to));
		message.setSubject( subject);
		message.setText( text);

		//send message
		Transport.send( message);
		System.out.println( "Message sent.");}
}