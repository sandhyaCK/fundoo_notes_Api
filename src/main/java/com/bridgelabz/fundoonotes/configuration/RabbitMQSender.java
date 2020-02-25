package com.bridgelabz.fundoonotes.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.response.MailObject;
import com.bridgelabz.fundoonotes.utility.MailServiceProvider;

@Component
public class RabbitMQSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private MailServiceProvider sender;

	@Value("exchanger")
	private String exchangeName;

	@Value("key")
	private String routingKey;

	public void send(MailObject message) {
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
	}

	/*
	 * @RabbitListener(queues ="myqueue") public void listener(MailObject msg) {
	 * sender.send(msg); }
	 */
}
