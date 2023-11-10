package io.gitHub.AugustoMello09.payment.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.gitHub.AugustoMello09.payment.model.Cartao;

@FeignClient(value = "msCards-service", path = "/cards-service")
public interface CardFeign {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cartao> findById(@PathVariable UUID id);

}
