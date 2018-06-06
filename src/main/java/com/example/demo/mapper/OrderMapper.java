package com.example.demo.mapper;

import com.example.demo.domain.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

	void insert(OrderItem orderItem);

	List<OrderItem> getAll();

}
