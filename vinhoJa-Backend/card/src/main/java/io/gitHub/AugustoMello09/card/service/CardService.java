package io.gitHub.AugustoMello09.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.gitHub.AugustoMello09.card.dto.CardDTO;
import io.gitHub.AugustoMello09.card.entity.Card;
import io.gitHub.AugustoMello09.card.repositories.CardRepository;

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

}
