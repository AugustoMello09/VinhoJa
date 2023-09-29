package io.gitHub.AugustoMello09.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.gitHub.AugustoMello09.user.dto.RoleDTO;
import io.gitHub.AugustoMello09.user.entities.Role;
import io.gitHub.AugustoMello09.user.repositories.RoleRepository;

@Service
public class RoleService {
		
	@Autowired
	private RoleRepository repository;
	
	@Transactional
	public RoleDTO create(RoleDTO objDto) {
		Role entity = new Role();
		entity.setAuthority(objDto.getAuthority());
		repository.save(entity);
		return new RoleDTO(entity);
	}
	
}
