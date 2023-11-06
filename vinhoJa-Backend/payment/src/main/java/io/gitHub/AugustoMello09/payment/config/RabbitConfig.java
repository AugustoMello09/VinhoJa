package io.gitHub.AugustoMello09.payment.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitConfig {

	@Value(value = "${mq.queues.emissao-pagamento}")
	private String emissaoPagamento;

	@Bean
	public Queue queueEmissaoFila() {
		return new Queue(emissaoPagamento, true);
	}

	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		ObjectMapper objectMapper = new ObjectMapper();
		return new Jackson2JsonMessageConverter(objectMapper);
	}

}
