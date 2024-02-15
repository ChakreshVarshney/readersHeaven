package com.ts.readersHeaven.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ts.readersHeaven.DTO.OrdersDto;
import com.ts.readersHeaven.Repository.OrderRepository;

import kafkaConfigFiles.KafkaProducerConfig;

@Service
public class OrderServiceImpl implements OrderService {

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    KafkaProducerConfig kafkaProducerConfig;
    @Autowired
	OrderRepository orderRepository;
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public OrdersDto addMsgInOrderQueue(OrdersDto order) {
		String json = "";
		try {
			json = mapper.writeValueAsString(order);
			logger.debug("ResultingJSONstring = {}", json);
		} catch (JsonProcessingException e) {
			logger.error("exception occur: {}", e);
		}
		kafkaProducerConfig.sendMessage(json);
		
		return null;
	}
	
	@Override
	public OrdersDto save(OrdersDto order) {
		return orderRepository.save(order);
	}



}
