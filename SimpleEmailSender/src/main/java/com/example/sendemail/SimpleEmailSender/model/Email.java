package com.example.sendemail.SimpleEmailSender.model;

import org.springframework.stereotype.Component;

@Component
public class Email {

	String to;
	String messageSubject;
	String messageBody;
	
	public Email() {
		
	}
	
	public Email(String to, String messageSubject) {
		super();
		this.to = to;
		this.messageSubject = messageSubject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
}
