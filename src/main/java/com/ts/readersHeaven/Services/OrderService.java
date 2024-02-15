package com.ts.readersHeaven.Services;

import com.ts.readersHeaven.DTO.OrdersDto;

public interface OrderService {

	OrdersDto addMsgInOrderQueue(OrdersDto order);

	OrdersDto save(OrdersDto order);

}
