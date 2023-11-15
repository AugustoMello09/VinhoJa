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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Payment endpoint")
@RestController
@RequestMapping(value = "/payment-service")
public class PaymentController {
	
	@Autowired
	private PaymentService service;

	@Operation(summary = "Status do microsservice.")
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@Operation(summary = "Mostra a situação do cliente como seus dados e cartão.")
	@GetMapping(value = "/situacaoCliente/Cliente/{idCliente}/Cartao/{idCartao}")
	public ResponseEntity<SituacaoCliente> situacaoCliente(@PathVariable UUID idCliente, @PathVariable UUID idCartao) {
		SituacaoCliente obj = service.obterSituacao(idCartao, idCliente);
		return ResponseEntity.ok().body(obj);
	}
	
	@Operation(summary = "Processa o pagamento com os ids do usuário e cartão.")
	@PostMapping(value = "/{idCartao}/{idUsuario}")
	public ResponseEntity<PaymentDTO> fazerPagamento(@RequestBody PaymentDTO obj, @PathVariable UUID idCartao,
			@PathVariable UUID idUsuario) {
		PaymentDTO newObj = service.processarPagameto(obj, idCartao, idUsuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}

}
