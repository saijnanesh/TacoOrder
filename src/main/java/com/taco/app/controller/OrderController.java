package com.taco.app.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.taco.app.model.TacoOrder;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

	public static final org.slf4j.Logger logger = LoggerFactory.getLogger("OrderController");

	@GetMapping("/current")
	public String order() {
		return "orderform";
	}

	/*
	 * In the case of this processOrder() method, the TacoOrder object is simply
	 * logged. But before processOrder() is done, it also calls setComplete() on
	 * the SessionStatus object passed in as a parameter.
	 */

	/*
	 * The TacoOrder object was initially created and placed into the session when
	 * the user created their first taco. By calling setComplete(), we are ensuring
	 * that the session is cleaned up and ready for a new order the next time the
	 * user creates a taco.
	 */

	@PostMapping
	public String processOrder(@Valid TacoOrder tacoOrder,BindingResult br ,SessionStatus sessionStatus) {
		if(br.hasErrors()) {
			logger.error(br.getFieldError().toString());
			return "orderform";
		}
		logger.info("Order submitted: {}", tacoOrder);
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
