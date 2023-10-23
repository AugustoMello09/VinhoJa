package io.gitHub.AugustoMello09.card.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.gitHub.AugustoMello09.card.dto.CardDTO;
import io.gitHub.AugustoMello09.card.entity.Card;
import io.gitHub.AugustoMello09.card.repositories.CardRepository;
import io.gitHub.AugustoMello09.card.service.exception.ObjectNotFoundException;

@Service
public class CardService {
	
	@Autowired
	private CardRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public CardDTO create(CardDTO obj) {
		Card entity = new Card();
		entity.setCpf(obj.getCpf());
		entity.setNomeCartao(obj.getNomeCartao());
		entity.setNumeroCartao(passwordEncoder.encode(obj.getNumeroCartao()));
		entity.setCod(passwordEncoder.encode(obj.getCod()));
		entity.setDataExp(obj.getDataExp());
		repository.save(entity);
		return new CardDTO(entity);
	}

	public CardDTO findById(UUID id) {
		Optional<Card> entity = repository.findById(id);
		Card obj = entity.orElseThrow(() -> new ObjectNotFoundException("ID não encontrado " + id));
		return new CardDTO(obj);
	}

}
