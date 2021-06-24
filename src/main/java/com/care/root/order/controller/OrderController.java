package com.care.root.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.care.root.order.dto.OrderDTO;
import com.care.root.order.mybatis.OrderMapper;
import com.care.root.order.service.OrderService;

@Controller("order")
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderMapper orderMapper;
	
	@RequestMapping(value="/orderEachGoods", method=RequestMethod.POST)
	public ModelAndView orderEachGoods(@ModelAttribute("orderDTO") OrderDTO _orderDTO,
			HttpServletRequest request, HttpServletResponse response) {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		session = request.getSession();
		
		Boolean isLogOn=(Boolean)session.getAttribute("isLogOn");
		String action=(String)session.getAttribute("action");
		
		if(isLogOn==null||isLogOn==false) {
			session.setAttribute("orderInfo", _orderDTO);
			session.setAttribute(action, "/order/orderEachGoods");
			return new ModelAndView("redirect:/member/loginForm");
		}else {
			if(action!=null&&action.equals("/order/orderEachGoods")) {
				orderDTO=(OrderDTO)session.getAttribute("orderInfo");
			}else {
				orderDTO=_orderDTO;
			}
		}
		
		
	}
	
	
}
