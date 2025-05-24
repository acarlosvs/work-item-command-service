package br.com.tasknow.workitemcommandservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public DirectExchange workItemExchangeDl() {
        return new DirectExchange("tasknow.create.v1.e.dl");
    }

    @Bean
    public Queue workItemQueueDl() {
        return QueueBuilder
                .durable("tasknow.create.v1.q.dl")
                .build();
    }

    @Bean
    public Binding workItemBindingDl() {
        return BindingBuilder
                .bind(workItemQueueDl())
                .to(workItemExchangeDl())
                .with("tasknow.create.v1.r.dl");
    }

    @Bean
    public DirectExchange workItemCreateExchange() {
        return new DirectExchange("tasknow.create.v1.e");
    }

    @Bean
    public Queue workItemCreateQueue() {
        return QueueBuilder
                .durable("tasknow.create.v1.q")
                .deadLetterExchange("tasknow.create.v1.e.dl")
                .deadLetterRoutingKey("tasknow.create.v1.r.dl")
                .build();
    }

    @Bean
    public Binding workItemCreateBinding() {
        return BindingBuilder
                .bind(workItemCreateQueue())
                .to(workItemCreateExchange())
                .with("tasknow.create.v1.r");
    }

    @Bean
    public DirectExchange workItemUpdateExchange() {
        return new DirectExchange("tasknow.create.v1.e");
    }

    @Bean
    public Queue workItemUpdateQueue() {
        return QueueBuilder
                .durable("tasknow.update.v1.q")
                .build();
    }

    @Bean
    public Binding workItemUpdateBinding() {
        return BindingBuilder
                .bind(workItemUpdateQueue())
                .to(workItemUpdateExchange())
                .with("tasknow.create.v1.r");
    }

    @Bean
    public Queue workItemDeleteQueue() {
        return QueueBuilder
                .durable("tasknow.delete.v1.q")
                .build();
    }

    @Bean
    public Binding workItemDeleteBinding() {
        return BindingBuilder
                .bind(workItemDeleteQueue())
                .to(workItemUpdateExchange())
                .with("tasknow.delete.v1.r");
    }
}

