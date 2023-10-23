package io.gitHub.AugustoMello09.payment.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private UUID id;
	private String nome;
	private String email;
}
