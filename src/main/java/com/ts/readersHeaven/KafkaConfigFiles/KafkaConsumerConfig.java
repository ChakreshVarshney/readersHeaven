package com.ts.readersHeaven.KafkaConfigFiles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ts.readersHeaven.DTO.OrdersDto;
import com.ts.readersHeaven.Services.OrderService;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	

	@Autowired
	OrderService orderService;


    
    @KafkaListener(topics = "orderQueue", groupId = "reader-haven")
    public void listenGroupFoo(String message) {
    	ObjectMapper objectMapper = new ObjectMapper();
    	OrdersDto ordersDto = null;
		try {
			ordersDto = objectMapper.readValue(message, OrdersDto.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	orderService.save(ordersDto);
        System.out.println("Received Message in group reader-haven: " + message);
    }
}