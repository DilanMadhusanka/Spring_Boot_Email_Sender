package com.example.sendemail.SimpleEmailSender.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sendemail.SimpleEmailSender.model.Email;

@RestController
@RequestMapping(value="/email")
public class SimpleEmailController {

	@Autowired
	public JavaMailSender javaMailSender;
	
	@RequestMapping(value="/sendEmail")
	public String sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("dilan.madhusanka289@gmail.com");
		message.setSubject("SpringBootApplication");
		message.setText("Hi How are you");
		
		javaMailSender.send(message);
		
		return "Successfully sent email";
	}
	
	@RequestMapping(value="/sendEmailContent")
	public String sendEmail(@RequestBody Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getMessageSubject());
		message.setText(email.getMessageBody());
		
		javaMailSender.send(message);
		
		return "Successfully sent email";
	}
	
	@RequestMapping("/sendEmailAttachement")
	public void sendEmailAttachement(@RequestParam String email, @RequestParam String messageSubject, @RequestParam String messageBody) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		Email emailModel = new Email(email,messageSubject, messageBody);
		
		helper.setTo(emailModel.getTo());
		helper.setSubject(emailModel.getMessageSubject());
		helper.setText(emailModel.getMessageBody());
		
		ClassPathResource path = new ClassPathResource("clouds.jpg");
		helper.addAttachment("clouds.jpg", path);
		
		javaMailSender.send(mimeMessage);
		
		
	}
}
