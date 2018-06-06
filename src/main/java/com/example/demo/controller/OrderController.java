package com.example.demo.controller;

import com.example.demo.domain.OrderItem;
import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

	@Autowired
	private OrderMapper mapper;

	@GetMapping("/get_all")
	public List<OrderItem> getAll(){
		return mapper.getAll();
	}
}
