package io.gitHub.AugustoMello09.card.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.gitHub.AugustoMello09.card.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID>{

}
