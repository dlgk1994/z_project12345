package com.care.root.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@RequestMapping("paymentForm")
	public String payment() {
		return "payment/paymentForm";
	}
	
}
