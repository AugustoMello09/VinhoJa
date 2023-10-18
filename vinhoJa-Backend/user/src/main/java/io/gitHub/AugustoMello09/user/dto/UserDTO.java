package io.gitHub.AugustoMello09.user.dto;

import java.io.Serializable;
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

	public UserDTO(User entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();

	}
}
