package io.gitHub.AugustoMello09.payment.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import feign.FeignException.FeignClientException;
import io.gitHub.AugustoMello09.payment.feign.CardFeign;
import io.gitHub.AugustoMello09.payment.feign.ClienteFeign;
import io.gitHub.AugustoMello09.payment.model.SituacaoCliente;
import io.gitHub.AugustoMello09.payment.services.exceptions.ClientException;
import io.gitHub.AugustoMello09.payment.services.exceptions.ErroComunicacaoMicrosserviceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentService {

	@Autowired
	private ClienteFeign clienteFeign;

	@Autowired
	private CardFeign cardFeign;

	public SituacaoCliente obterSituacao(UUID idCartao, UUID idCliente) {
		try {
			var cliente = clienteFeign.findById(idCliente);
			log.info("Cliente ID: " + idCliente);
			var cartao = cardFeign.findById(idCartao);
			log.info("Cartao ID: " + idCartao);
			return SituacaoCliente.builder().cliente(cliente.getBody()).cartao(cartao.getBody()).build();
		} catch (FeignClientException e) {
			int status = e.status();
			if (HttpStatus.NOT_FOUND.value() == status) {
				throw new ClientException("Dados fornecidos não encontrado");
			} else {
				throw new ErroComunicacaoMicrosserviceException("Erro na comunicação entre Microsservices ", status);
			}
			
		}
		
	}

}
