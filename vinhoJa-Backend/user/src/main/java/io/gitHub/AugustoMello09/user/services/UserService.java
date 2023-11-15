package io.gitHub.AugustoMello09.user.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.gitHub.AugustoMello09.user.dto.UserDTO;
import io.gitHub.AugustoMello09.user.entities.User;
import io.gitHub.AugustoMello09.user.repositories.UserRepository;
import io.gitHub.AugustoMello09.user.services.exceptions.DataIntegratyViolationException;
import io.gitHub.AugustoMello09.user.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional
	public UserDTO create(UserDTO objDto) {
		findByEmail(objDto);
		User entity = new User();
		entity.setNome(objDto.getNome());
		entity.setEmail(objDto.getEmail());
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	public UserDTO findById(UUID id) {
		Optional<User> entity = repository.findById(id);
		User obj = entity.orElseThrow(() -> new ObjectNotFoundException("ID não encontrado"));
		return new UserDTO(obj);
	}
	
	public void findByEmail(UserDTO obj) {
		Optional<User> entity = repository.findByEmail(obj.getEmail());
		if (entity.isPresent() && !entity.get().getId().equals(obj.getId())) {
			throw new DataIntegratyViolationException("Email já existe");
		}
	}

}
