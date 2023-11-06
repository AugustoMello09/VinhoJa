package io.gitHub.AugustoMello09.email.infra.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

	@RabbitListener(queues = "${mq.queues.emissao-pagamento}")
	public void receberSolicitacaoConfirmacao(@Payload String payload) {
		System.out.println(payload);
	}
}
