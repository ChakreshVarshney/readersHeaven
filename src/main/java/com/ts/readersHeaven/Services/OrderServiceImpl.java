package com.ts.readersHeaven.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ts.readersHeaven.DTO.OrdersDto;
import com.ts.readersHeaven.KafkaConfigFiles.KafkaProducerConfig;
import com.ts.readersHeaven.Repository.OrderRepository;



@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    
    @Autowired
    KafkaProducerConfig kafkaProducerConfig;
    
    @Autowired
	OrderRepository orderRepository;
    
	private String topicName = "orderQueue";

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
		sendMessage(json);
		
		return null;
	}
	
	@Override
	public OrdersDto save(OrdersDto order) {
		return orderRepository.save(order);
	}

    public void sendMessage(String msg) {
        kafkaTemplate.send(topicName , msg);
    }


}
