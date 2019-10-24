package com.training.msa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.msa.email.Email;
import com.training.msa.email.JmsSender;

@RestController
public class NotificationRestController {
	
	@Autowired
	private JmsSender jmsSender;

	@PostMapping("/notif/email")
	public Email sendEmail (@RequestBody  Email email) {
		
		System.out.println("masuk: " + email.getBody());
		
		jmsSender.sendEmailMessage(email);
		
		return email;
	}
	
}
