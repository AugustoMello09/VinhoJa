package io.gitHub.AugustoMello09.email.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@Tag(name = "Email endpoint")
@RestController
@RequestMapping(value = "/email-service")
public class EmailController {
	
	@Operation(summary = "Status do microsservice.")
	@GetMapping
	public String status() {
		return "ok";
	}
}
