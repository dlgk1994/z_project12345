package com.care.root.order.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.care.root.order.dto.OrderDTO;

public interface OrderMapper {
	public List<OrderDTO> listMyOrderGoods(OrderDTO orderBean) throws DataAccessException;
	public void insertNewOrder(List<OrderDTO> myOrderList) throws DataAccessException;
	public OrderDTO findMyOrder(String order_id) throws DataAccessException;
	public void removeGoodsFromCart(List<OrderDTO> myOrderList) throws DataAccessException;
	
}
