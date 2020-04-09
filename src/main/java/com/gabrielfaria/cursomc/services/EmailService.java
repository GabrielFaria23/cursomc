package com.gabrielfaria.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.gabrielfaria.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
<<<<<<< HEAD
<<<<<<< HEAD
	//void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	//void sendHtmlEmail(MimeMessage msg);
=======
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
>>>>>>> 487bbca4b682fbb57007a7930bdec68c9def70b4
=======
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
>>>>>>> 487bbca4b682fbb57007a7930bdec68c9def70b4
}
