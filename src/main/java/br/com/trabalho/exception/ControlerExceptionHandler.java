package br.com.trabalho.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControlerExceptionHandler extends ResponseEntityExceptionHandler {

	List<String> erros = new ArrayList<>();
	ErroResposta erroResposta=null;
	
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<Object> handleEmailException(EmailException ex) {
		EmailException emailException = new EmailException(ex.getMessage());
		return ResponseEntity.unprocessableEntity().body(emailException);
	}
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		erros = verificaErros(ex);
		erroResposta = new ErroResposta(status.value(), "Existem campos inválidos!", LocalDateTime.now(),
				erros);
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

	private List<String> verificaErros(MethodArgumentNotValidException ex) {
		List<String> erros = new ArrayList<>();
		for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
			erros.add(erro.getField() + ":" + erro.getDefaultMessage());
		}
		return erros;
	}

	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			erroResposta = new ErroResposta(status.value(), "Existem campos inválidos notReadble!", LocalDateTime.now(),erros);

			return new ResponseEntity<Object>(erroResposta,HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(ConstraintViolationException.class)
	  public ResponseEntity<Object> onConstraintValidationException(
	      ConstraintViolationException e) {
		 erroResposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(), "Existem campos inválidos contraint!", LocalDateTime.now(),erros);
	    for (ConstraintViolation violation : e.getConstraintViolations()) {
	    	erros.add(violation.getMessage());
	    }
	    return new ResponseEntity<Object>(erroResposta,HttpStatus.BAD_REQUEST);
	  }
}
