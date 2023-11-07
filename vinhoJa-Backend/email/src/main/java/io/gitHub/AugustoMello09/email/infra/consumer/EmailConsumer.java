package io.gitHub.AugustoMello09.email.infra.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import io.gitHub.AugustoMello09.email.dto.EmailDTO;
import io.gitHub.AugustoMello09.email.entities.Email;
import io.gitHub.AugustoMello09.email.services.EmailService;

@Component
public class EmailConsumer {
	
	@Autowired
	private EmailService service;

	@RabbitListener(queues = "${mq.queues.emissao-pagamento}")
	public void receberSolicitacaoConfirmacao(@Payload EmailDTO dto) {
		var emailModel = new Email();
		BeanUtils.copyProperties(dto, emailModel);
		service.sendEmail(emailModel);
	}
}
