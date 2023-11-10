package io.gitHub.AugustoMello09.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/users-service/**").uri("lb://msUsers-service"))
				.route(r -> r.path("/cards-service/**").uri("lb://msCards-service"))
				.route(r -> r.path("/payment-service/**").uri("lb://msPayment-service"))
				.route(r -> r.path("/email-service/**").uri("lb://msEmail-service"))
				.build();
	}

}
