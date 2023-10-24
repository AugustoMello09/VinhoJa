package io.gitHub.AugustoMello09.payment.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.gitHub.AugustoMello09.payment.model.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentDTO {
	
	private Long id;
	private BigDecimal valor;
	private LocalDate data;
	
	public PaymentDTO(Payment entity) {
		id = entity.getId();
		valor = entity.getValor();
		data = entity.getData();
	}
}
