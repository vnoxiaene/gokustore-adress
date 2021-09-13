package com.vnoxiaene.gokustore.address.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

public class AmqpConfiguration {
//
//    @Value("${amqp.username}")
//    private String userName;
//
//    @Value("${amqp.password}")
//    private String password;
//
//    @Value("${amqp.virtualHost}")
//    private String virtualHost;
//
//    @Value("${amqp.host}")
//    private String host;
//
//    @Value("${amqp.port}")
//    private String port;
//
//    @Value("${amqp.uri}")
//    private String uri;
//
//    @Value("${gokustore.address.save}")
//    private String saveAddressQueue;
//
//    @Value("${gokustore.address.update}")
//    private String updateAddressQueue;
//
//    @Value("${gokustore.address.delete}")
//    private String deleteAddressQueue;
//
//    @Value("${gokustore.address.listByCEP}")
//    private String listAddressByCEPQueue;
//
//    @Value("${gokustore.direct.exchange}")
//    private String directExchange;
//
//    @Bean
//    public ConnectionFactory jmsConnectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setUsername(userName);
//        connectionFactory.setPassword(password);
//        connectionFactory.setVirtualHost(virtualHost);
//        connectionFactory.setPort(Integer.valueOf(port));
//        connectionFactory.setUri(uri);
//        connectionFactory.setHost(host);
//        return connectionFactory;
//    }
//
//    @Primary
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setReplyTimeout(600000);
//        return rabbitTemplate;
//    }
//
//    @Bean
//    public Queue saveAddressQueue() {
//        return new Queue(saveAddressQueue);
//    }
//
//    @Bean
//    public Queue updateAddressQueue() {
//        return new Queue(updateAddressQueue);
//    }
//
//    @Bean
//    public Queue deleteAddressQueue() {
//        return new Queue(deleteAddressQueue);
//    }
//
//    @Bean
//    public Queue listAddressByCEPQueue() {
//        return new Queue(listAddressByCEPQueue);
//    }
//
//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange(directExchange);
//    }
//
//
//    @Bean
//    Binding bindingSaveAddressQueue() {
//        return BindingBuilder.bind(saveAddressQueue()).to(exchange()).with(saveAddressQueue);
//    }
//    @Bean
//    Binding bindingUpdateAddressQueue() {
//        return BindingBuilder.bind(updateAddressQueue()).to(exchange()).with(updateAddressQueue);
//    }
//    @Bean
//    Binding bindingDeleteAddressQueue() {
//        return BindingBuilder.bind(deleteAddressQueue()).to(exchange()).with(deleteAddressQueue);
//    }
//    @Bean
//    Binding bindingListAddressByCEPQueue() {
//        return BindingBuilder.bind(listAddressByCEPQueue()).to(exchange()).with(listAddressByCEPQueue);
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer( ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
//        container.setMissingQueuesFatal(false);
//        return container;
//    }
}
