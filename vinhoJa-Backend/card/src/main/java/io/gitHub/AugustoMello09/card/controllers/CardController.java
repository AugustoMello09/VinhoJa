package io.gitHub.AugustoMello09.card.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.gitHub.AugustoMello09.card.dto.CardDTO;
import io.gitHub.AugustoMello09.card.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Card endpoint")
@RestController
@RequestMapping(value = "/cards-service")
public class CardController {
	
	@Autowired
	private CardService service;
	
	@Operation(summary = "Status do microsservice.")
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@Operation(summary = "Cria um cartão no banco de dados.")
	@PostMapping
	public ResponseEntity<CardDTO> create(@RequestBody CardDTO obj){
		CardDTO newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.query("id={id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}
	
	@Operation(summary = "Busca um Cartão no banco de dados por UUID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<CardDTO> findById(@PathVariable UUID id){
		CardDTO card = service.findById(id);
		return ResponseEntity.ok().body(card);
	}
	
	@Operation(summary = "Busca um Cartão no banco de dados por número de cartão.")
	@GetMapping(value = "/search")
	public ResponseEntity<CardDTO> findByNumeroCartao(@RequestParam(value = "numeroCartao") String numeroCartao){
		CardDTO obj = service.findByNumeroCartao(numeroCartao);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
