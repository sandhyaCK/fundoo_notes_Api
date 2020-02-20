package com.bridgelabz.fundoonotes.configuration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.response.MailObject;
//import com.bridgelabz.fundoonotes.utility.MailServiceProvider;

@Component

public class RabbitMQSender {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("rmq.rube.exchange")
	private String exchangeName;

	@Value("rube.key")
	private String routingKey;

	public void produceMsg(MailObject message) {
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
	}

	 }