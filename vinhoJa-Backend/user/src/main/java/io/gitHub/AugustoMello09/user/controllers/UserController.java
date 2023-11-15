package io.gitHub.AugustoMello09.user.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.gitHub.AugustoMello09.user.dto.UserDTO;
import io.gitHub.AugustoMello09.user.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User endpoint")
@RestController
@RequestMapping(value = "/users-service")
public class UserController {

	@Autowired
	private UserService service;

	@Operation(summary = "Status do microsservice.")
	@GetMapping
	public String status() {
		return "ok";
	}

	@Operation(summary = "Busca um usuário no banco de dados por UUID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
		UserDTO entityDto = service.findById(id);
		return ResponseEntity.ok().body(entityDto);
	}

	@Operation(summary = "Cria um usuário no banco de dados.")
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO objDto) {
		UserDTO newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().query("id={id}").buildAndExpand(newObj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newObj);
	}

}
