package io.gitHub.AugustoMello09.user.dto;

import java.io.Serializable;
import java.util.UUID;

import io.gitHub.AugustoMello09.user.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private UUID id;
	
	@Size(max = 35, message = "Deve ter no máximo 35 caracteres.")
	@NotBlank(message = "Campo Obrigatório.")
	private String nome;
	
	@Email(message = "Deve ser um endereço de email válido.")
	@NotBlank(message = "Campo Obrigatório.")
	private String email;

	public UserDTO(User entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();

	}
}
