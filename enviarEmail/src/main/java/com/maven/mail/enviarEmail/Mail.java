package com.maven.mail.enviarEmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Antes hay que bajar la seguridad al sistema de Gmail
 * https://myaccount.google.com/lesssecureapps
 *
 */
public class Mail {

	public static void main(String[] args) {

        Mail mail = new Mail("....@gmail.com", " .... ");
        mail.enviaStartTLS("....@gmail.com", ".....", "test", "Envio de test.");

    }

    private String usuario;
    private String pass;

    public Mail(String usuario, String pass){
        this.usuario=usuario;
        this.pass=pass;
    }

    public void enviaStartTLS(String from, String to, String subject, String text){
        final String username = usuario;
        final String password = pass;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            System.out.println("Enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
