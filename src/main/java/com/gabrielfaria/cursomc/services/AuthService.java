package com.gabrielfaria.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gabrielfaria.cursomc.domain.Cliente;
import com.gabrielfaria.cursomc.repositories.ClienteRepository;
import com.gabrielfaria.cursomc.services.exception.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();

	public void  sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass); 
		
	}

	private String newPassword() {
		
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { //gera um digito
			return (char) (rand.nextInt(10) + 48); // 10 porque de 0 a 10 da 10 números e + 48 porque 48 é o codigo do 0 na tabela encode
		}
		else if(opt == 1) {//gera letra minuscula
			return (char) (rand.nextInt(26) + 65); // 26 porque é o número de letras do alfabeto e + 65 porque 65 é o codigo do A na tabela encode
		}
		else {
			return (char) (rand.nextInt(26) + 97); // 26 porque é o número de letras do alfabeto e + 97 porque 97 é o codigo do a na tabela encode
		}
	}
}
