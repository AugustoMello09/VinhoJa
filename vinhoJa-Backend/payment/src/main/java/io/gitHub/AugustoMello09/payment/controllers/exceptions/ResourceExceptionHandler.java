package io.gitHub.AugustoMello09.payment.controllers.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.gitHub.AugustoMello09.payment.services.exceptions.ClientException;
import io.gitHub.AugustoMello09.payment.services.exceptions.ErroComunicacaoMicrosserviceException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ClientException.class)
	public ResponseEntity<StandardError> objectNotFound(ClientException e, HttpServletRequest request){
		StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(ErroComunicacaoMicrosserviceException.class)
	public ResponseEntity<StandardError> erroMs(ErroComunicacaoMicrosserviceException e, HttpServletRequest request){
		StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.SERVICE_UNAVAILABLE.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
	}

}
