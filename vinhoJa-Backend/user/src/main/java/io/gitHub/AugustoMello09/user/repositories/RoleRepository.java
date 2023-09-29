package io.gitHub.AugustoMello09.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.gitHub.AugustoMello09.user.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
