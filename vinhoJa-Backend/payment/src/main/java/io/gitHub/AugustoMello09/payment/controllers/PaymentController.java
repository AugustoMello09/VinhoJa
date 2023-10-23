package io.gitHub.AugustoMello09.payment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	@GetMapping
	public String status() {
		return "ok";
	}

}
