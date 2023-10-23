package io.gitHub.AugustoMello09.payment.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SituacaoCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Cliente cliente;
	private Cartao cartao;
}
