package com.example.demo.domain;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderItem {
	private int orderId;
	private int userId;
}
