package com.example.demo;

import com.example.demo.domain.OrderItem;
import com.example.demo.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcShardingDemoApplicationTests {

	@Autowired
	private OrderMapper mapper;

	@Test
	public void contextLoads() {
		List<OrderItem> all = mapper.getAll();
		System.out.println(all.size());
		all.forEach(System.out::println);
	}

	@Test
	public void insertTest(){
		OrderItem item = new OrderItem();
		item.setOrderId(1111);
		item.setUserId(1111);
		mapper.insert(item);
	}
}
