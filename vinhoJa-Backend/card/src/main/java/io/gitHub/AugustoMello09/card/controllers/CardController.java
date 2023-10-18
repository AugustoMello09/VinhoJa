package io.gitHub.AugustoMello09.card.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cards")
public class CardController {
	
	@GetMapping
	public String status() {
		return "ok";
	}
}
