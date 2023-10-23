package io.gitHub.AugustoMello09.payment.services.exceptions;

import lombok.Getter;

public class ErroComunicacaoMicrosserviceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Getter
	private Integer status;

	public ErroComunicacaoMicrosserviceException(String message,Integer status) {
		super(message);
		this.status = status;

	}

}
