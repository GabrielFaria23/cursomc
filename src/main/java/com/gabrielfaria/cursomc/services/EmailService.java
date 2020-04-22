package com.gabrielfaria.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.gabrielfaria.cursomc.domain.Cliente;
import com.gabrielfaria.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
	
	//void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	//void sendHtmlEmail(MimeMessage msg);

}
