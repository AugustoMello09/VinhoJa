package io.gitHub.AugustoMello09.card.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.gitHub.AugustoMello09.card.dto.CardDTO;
import io.gitHub.AugustoMello09.card.service.CardService;

@RestController
@RequestMapping(value = "/cards")
public class CardController {
	
	@Autowired
	private CardService service;
	
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@PostMapping
	public ResponseEntity<CardDTO> create(@RequestBody CardDTO obj){
		CardDTO newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.query("id={id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}
	
	
	
}
