package io.gitHub.AugustoMello09.payment.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.gitHub.AugustoMello09.payment.dto.PaymentDTO;
import io.gitHub.AugustoMello09.payment.model.SituacaoCliente;
import io.gitHub.AugustoMello09.payment.services.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@GetMapping(value = "/situacaoCliente/Cliente/{idCliente}/Cartao/{idCartao}")
	public ResponseEntity<SituacaoCliente> situacaoCliente(@PathVariable UUID idCliente, @PathVariable UUID idCartao){
		SituacaoCliente obj = service.obterSituacao(idCartao, idCliente);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/{idCartao}")
	public ResponseEntity<PaymentDTO> fazerPagamento(@RequestBody PaymentDTO obj, @PathVariable UUID idCartao){
		PaymentDTO newObj = service.processarPagameto(obj, idCartao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}

}
