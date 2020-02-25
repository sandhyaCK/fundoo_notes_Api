package com.bridgelabz.fundoonotes.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.response.MailObject;

@Service
public class RabbitMQSender {

	 @Autowired
	private AmqpTemplate amqpTemplate;

	@Value("exchanger")
	private String exchange;

	@Value("key")
	private String routingkey;

	public void send(MailObject mailResponse) {
		amqpTemplate.convertAndSend(exchange, routingkey, mailResponse);
		System.out.println("Send msg = " + mailResponse);

	}
}