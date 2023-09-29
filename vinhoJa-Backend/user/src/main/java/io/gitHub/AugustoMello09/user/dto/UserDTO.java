package io.gitHub.AugustoMello09.user.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import io.gitHub.AugustoMello09.user.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private UUID id;

	
	private String nome;

	
	private String email;


	private Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO(User entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		entity.getRoles().forEach(x -> this.roles.add(new RoleDTO(x)));
		
	}
}
