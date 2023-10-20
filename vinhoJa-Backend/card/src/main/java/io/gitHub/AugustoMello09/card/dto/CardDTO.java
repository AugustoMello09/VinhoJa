package io.gitHub.AugustoMello09.card.dto;

import java.util.UUID;

import io.gitHub.AugustoMello09.card.entity.Card;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardDTO {

	private UUID id;

	private String cpf;

	private String nomeCartao;

	private String numeroCartao;

	private String cod;
	
	private String dataExp;
	
	public CardDTO(Card entity) {
		id = entity.getId();
		cpf = entity.getCpf();
		nomeCartao = entity.getNomeCartao();
		numeroCartao = entity.getNumeroCartao();
		cod = entity.getCod();
		dataExp = entity.getDataExp();
	}

}
