package com.code041.framework.api.exception;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandlerInterface {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handle() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handle(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(ValidationErrorRecord::new).toList());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handle(HttpMessageNotReadableException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<?> handle(BadCredentialsException ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials");
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<?> handle(AuthenticationException ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<?> handle(AccessDeniedException ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handle(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + ex.getLocalizedMessage());
	}

	record ValidationErrorRecord(String campo, String mensagem) {
		public ValidationErrorRecord(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}