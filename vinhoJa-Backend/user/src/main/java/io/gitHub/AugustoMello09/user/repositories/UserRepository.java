package io.gitHub.AugustoMello09.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.gitHub.AugustoMello09.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

	User findByEmail(String cpf);

}
