package io.gitHub.AugustoMello09.payment.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class Cartao implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private UUID id;

	private String cpf;

	private String nomeCartao;

	private String numeroCartao;

	private String cod;

	private String dataExp;
}
