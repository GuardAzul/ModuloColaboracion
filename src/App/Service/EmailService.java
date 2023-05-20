package App.Service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	public static boolean enviarEmail(String asunto, String contenido, String destinatario) {
		
		String correoEmpresa = "poutypvp@gmail.com";
		String clave = "no";
		
		Properties propiedades = new Properties();
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		propiedades.put("mail.smtp.starttls.enable", "true");
		propiedades.put("mail.smtp.port", "587");
		propiedades.put("mail.smtp.user", correoEmpresa);
		propiedades.put("mail.smtp.clave", clave);
		propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
		propiedades.put("mail.smtp.auth", "true");
		
	    Session sesion = Session.getDefaultInstance(propiedades);
	    MimeMessage mensaje = new MimeMessage(sesion);
	    
	    try {
			mensaje.setFrom(new InternetAddress(correoEmpresa));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			mensaje.setSubject(asunto);
			mensaje.setText(contenido, "ISO-8859-1", "html"); // Con esto el contenido podrá ser html
			
			Transport transporte = sesion.getTransport("smtp");
			transporte.connect("smtp.gmail.com", correoEmpresa, clave);
	        transporte.sendMessage(mensaje, mensaje.getAllRecipients());
	        transporte.close();
	        
	        return true;	
	        
		} catch (Exception e) {		
			return false;	
		}
	}
}
