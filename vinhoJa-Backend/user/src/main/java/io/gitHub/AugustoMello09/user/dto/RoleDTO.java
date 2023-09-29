package io.gitHub.AugustoMello09.user.dto;

import java.io.Serializable;

import io.gitHub.AugustoMello09.user.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String authority;
	
	public RoleDTO(Role entity) {
		this.id = entity.getId();
		this.authority = entity.getAuthority();
	}

}
