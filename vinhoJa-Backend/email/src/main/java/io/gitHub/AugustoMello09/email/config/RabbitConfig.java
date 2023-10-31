package io.gitHub.AugustoMello09.email.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitConfig {
	
	
	@RabbitListener(queues = "${mq.queues.emissao-pagamento}")
	public void receberSolicitacaoConfirmacao(@Payload String payload) {
		System.out.println(payload);
	}
}
