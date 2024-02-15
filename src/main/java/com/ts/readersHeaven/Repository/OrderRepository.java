package com.ts.readersHeaven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ts.readersHeaven.DTO.OrdersDto;

public interface OrderRepository extends JpaRepository<OrdersDto, Long> {

}
