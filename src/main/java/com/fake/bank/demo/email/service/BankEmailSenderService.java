package com.fake.bank.demo.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 
 * @author USER This is generic simple message email sender service
 */

@Service
public class BankEmailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public String sendEmail(String recipient, String subject, String mailContent) {
		try {
			// use mailSender here...
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(recipient);
			message.setSubject(subject);
			message.setText(mailContent);

			mailSender.send(message);
		} // Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
		return "Mail Sent Successfully...";
	}
}
