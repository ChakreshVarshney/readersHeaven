package com.ts.readersHeaven.DTO;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "orders")
public class OrdersDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private long orderId;
	@Column(name = "customer_id")
	private long customerId;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "status_id")
	private long statusId;
	@Column(name = "shipping_option")
	private String shippingOpt;
	@Column(name = "total_price")
	private double totalPrice;
//	public long getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(long orderId) {
//		this.orderId = orderId;
//	}
//	public long getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//	}
//	public Date getOrderDate() {
//		return orderDate;
//	}
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}
//	public long getStatusId() {
//		return statusId;
//	}
//	public void setStatusId(long statusId) {
//		this.statusId = statusId;
//	}
//	public String getShippingOpt() {
//		return shippingOpt;
//	}
//	public void setShippingOpt(String shippingOpt) {
//		this.shippingOpt = shippingOpt;
//	}
//	public double getTotalPrice() {
//		return totalPrice;
//	}
//	public void setTotalPrice(double totalPrice) {
//		this.totalPrice = totalPrice;
//	}
	

}
