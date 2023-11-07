package io.gitHub.AugustoMello09.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.gitHub.AugustoMello09.email.entities.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {

}
