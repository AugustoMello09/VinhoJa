package io.gitHub.AugustoMello09.email.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailController {
	
	@GetMapping
	public String status() {
		return "ok";
	}
}
