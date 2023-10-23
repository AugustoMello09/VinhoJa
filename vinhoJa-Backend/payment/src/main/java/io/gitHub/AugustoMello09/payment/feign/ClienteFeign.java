package io.gitHub.AugustoMello09.payment.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.gitHub.AugustoMello09.payment.model.Cliente;

@FeignClient(value = "msUsers", path = "/users")
public interface ClienteFeign {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable UUID id);

}
