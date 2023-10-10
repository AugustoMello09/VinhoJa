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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.gitHub.AugustoMello09.user.dto.UserDTO;
import io.gitHub.AugustoMello09.user.dto.UserDTOInsert;
import io.gitHub.AugustoMello09.user.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable UUID id){
		UserDTO entityDto = service.findById(id);
		return ResponseEntity.ok().body(entityDto);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTOInsert objDto){
		UserDTO newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.query("id={id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(newObj);
	}
	
	
	@GetMapping(value = "/search")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam(value = "email") String email){
		UserDTO obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	


}
