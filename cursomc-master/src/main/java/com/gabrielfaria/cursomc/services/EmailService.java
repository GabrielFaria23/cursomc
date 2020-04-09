package com.gabrielfaria.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.gabrielfaria.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
