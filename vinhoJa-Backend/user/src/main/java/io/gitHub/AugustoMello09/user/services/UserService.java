package io.gitHub.AugustoMello09.user.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.gitHub.AugustoMello09.user.dto.RoleDTO;
import io.gitHub.AugustoMello09.user.dto.UserDTO;
import io.gitHub.AugustoMello09.user.dto.UserDTOInsert;
import io.gitHub.AugustoMello09.user.entities.Role;
import io.gitHub.AugustoMello09.user.entities.User;
import io.gitHub.AugustoMello09.user.repositories.RoleRepository;
import io.gitHub.AugustoMello09.user.repositories.UserRepository;
import io.gitHub.AugustoMello09.user.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional
	public UserDTO create(UserDTOInsert objDto) {
		User entity = new User();
		copyToEntity(objDto, entity);
		entity.setSenha(passwordEncoder.encode(objDto.getSenha()));
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	public UserDTO findById(UUID id) {
		Optional<User> entity = repository.findById(id);
		User obj = entity.orElseThrow(() -> new ObjectNotFoundException("ID não encontrado"));
		return new UserDTO(obj);
	}

	protected void copyToEntity(UserDTO dto, User entity) {
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		for (RoleDTO roleDto : dto.getRoles()) {
			Role role = roleRepository.findById(roleDto.getId()).get();
			entity.getRoles().add(role);
		}
	}

	public UserDTO findByEmail(String cpf) {
		User user = repository.findByEmail(cpf);
		if (user == null) {
			throw new ObjectNotFoundException("Cpf não encontrado");
		}
		return new UserDTO(user);
	}

}
