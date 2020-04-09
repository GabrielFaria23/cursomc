package com.gabrielfaria.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando email...");
		mailSender.send(msg);
		LOG.info("Email enviado");
	}

<<<<<<< HEAD
<<<<<<< HEAD
	/*@Override
=======
	@Override
>>>>>>> 487bbca4b682fbb57007a7930bdec68c9def70b4
=======
	@Override
>>>>>>> 487bbca4b682fbb57007a7930bdec68c9def70b4
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando email...");
		javaMailSender.send(msg);
		LOG.info("Email enviado");
<<<<<<< HEAD
<<<<<<< HEAD
	}*/
=======
	}
>>>>>>> 487bbca4b682fbb57007a7930bdec68c9def70b4
=======
	}
>>>>>>> 487bbca4b682fbb57007a7930bdec68c9def70b4
}
