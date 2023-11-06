package io.gitHub.AugustoMello09.payment.infra;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.gitHub.AugustoMello09.payment.dto.EmailDTO;
import io.gitHub.AugustoMello09.payment.model.Cliente;


@Component
public class PaymentProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value(value = "${mq.queues.emissao-pagamento}")
	private String emissaoPagamento;
	
	public void paymentConfirmation(Cliente dto) {
		var emailDto = new EmailDTO();
        emailDto.setUserId(dto.getId());
        emailDto.setEmailTo(dto.getEmail());
        emailDto.setSubject("Compra realizada com sucesso!");
        emailDto.setText(dto.getNome() + ", seja bem vindo(a)! \nAgradecemos pela confiança");

        rabbitTemplate.convertAndSend("", emissaoPagamento, emailDto);
	}
	
	
}
