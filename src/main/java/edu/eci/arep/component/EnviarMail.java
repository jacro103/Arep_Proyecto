package edu.eci.arep.component;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarMail {
    private static String emailEnvio = "halsservicesltd@gmail.com";
    private static String passwordEnvio = "rwbptgqqiyxsylpj";
    private String asunto = "Confirmacion de Agendamiento de Consulta - Hals Services";
    private String contenido = "Estimado usuario, nos permitimos informarle que su consulta ha sido agendada correctamente.";
    private Properties propiedades;
    private Session sesion;
    private MimeMessage correo;
    

    public EnviarMail(){
        propiedades = new Properties();
    }

    public void crearCorreo(String destinatario){

        //Configuracion SMTP:
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.user", emailEnvio);
        propiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        propiedades.setProperty("mail.smtp.auth", "true");

        //Sesion:
        sesion = Session.getDefaultInstance(propiedades);

        //Correo:
        try {
            correo = new MimeMessage(sesion);
            correo.setFrom(new InternetAddress(emailEnvio));
            correo.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            correo.setSubject(asunto);
            correo.setText(contenido, "ISO-8859-1", "html");
             
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void enviarCorreo(String detinatario){
        crearCorreo(detinatario);
        try {
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(emailEnvio, passwordEnvio);
            transporte.sendMessage(correo, correo.getRecipients(Message.RecipientType.TO));
            transporte.close();
        } catch (NoSuchProviderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
