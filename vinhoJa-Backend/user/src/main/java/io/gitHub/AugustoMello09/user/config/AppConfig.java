package io.gitHub.AugustoMello09.user.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {
	
	@Value("${mq.queues.solicitacao-email}")
	private String emissaoEmailFila;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public Queue queueEmissaoEmail() {
		return new Queue(emissaoEmailFila, true);
	}
}
