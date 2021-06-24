package com.care.root.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.order.dto.OrderDTO;
import com.care.root.order.mybatis.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public List<OrderDTO> listMyOrderGoods(OrderDTO orderDTO) throws Exception {
		List<OrderDTO> orderGoodsList;
		orderGoodsList = orderMapper.listMyOrderGoods(orderDTO);
		return orderGoodsList;
	}

	@Override
	public void addNewOrder(List<OrderDTO> myOrderList) throws Exception {
		orderMapper.insertNewOrder(myOrderList);
		orderMapper.removeGoodsFromCart(myOrderList);
		
	}

	@Override
	public OrderDTO findMyOrder(String order_id) throws Exception {
		return orderMapper.findMyOrder(order_id);
	}

}
