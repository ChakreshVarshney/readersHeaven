package com.ts.readersHeaven.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.readersHeaven.DTO.OrdersDto;
import com.ts.readersHeaven.Repository.OrderRepository;
import com.ts.readersHeaven.Services.OrderService;



@RestController
public class ReadersHeavenController {
    Logger logger = LoggerFactory.getLogger(ReadersHeavenController.class);
    
   
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderService orderService;

	
	@PostMapping(path = "/saveOrder")
	public void saveOrder(@RequestBody OrdersDto order) {
		logger.info("order from json = {}",order.toString());
		OrdersDto newOrder = orderService.addMsgInOrderQueue(order);
		logger.debug("newOrder = {}",newOrder);
	}
	


}
