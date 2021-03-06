package com.bridgelabz.fundoonotes.configuration;

/*
 *  author : Sandhya
 */

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

	@Value("myqueue")
	String queueName;

	@Value("exchanger")
	String exchange;

	@Value("key")
	private String routingkey;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}

	@Bean
	public Jackson2JsonMessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory rabbitConnectionFactory) {
		RabbitTemplate rt = new RabbitTemplate(rabbitConnectionFactory);
		rt.setExchange(exchange);
		rt.setRoutingKey(routingkey);
		rt.setMessageConverter(jsonMessageConverter());
		return rt;
	}
//	 @Bean
//	    MessageListenerAdapter listenerAdapter(RabbitMqListener listener) {
//	        return new MessageListenerAdapter(listener, "listen");
//	    }
}
