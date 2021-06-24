package com.care.root.order.service;

import java.util.List;

import com.care.root.order.dto.OrderDTO;

public interface OrderService {
	public List<OrderDTO> listMyOrderGoods(OrderDTO orderDTO) throws Exception;
	public void addNewOrder(List<OrderDTO> myOrderList) throws Exception;
	public OrderDTO findMyOrder(String order_id) throws Exception;
}
