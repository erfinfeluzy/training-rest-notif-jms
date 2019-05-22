package com.training.msa.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {

	@Autowired
	@Qualifier("jacksonMessageConverter")
	private MessageConverter jacksonMessageConverter;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendEmailMessage(Email email) {
		jmsTemplate.setMessageConverter(jacksonMessageConverter);
		jmsTemplate.convertAndSend("q.email", email);
	}
	
}
