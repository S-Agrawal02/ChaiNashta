package com.example.ChaiNashta.service;

import com.example.ChaiNashta.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.order-topic.name}")
    private String topicName;

    public OrderKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNewOrder(Order order) {
        try {
            // Serialize the Order object to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonData = objectMapper.writeValueAsString(order);
            kafkaTemplate.send(topicName, jsonData);
            System.out.println("Message sent: " + jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
