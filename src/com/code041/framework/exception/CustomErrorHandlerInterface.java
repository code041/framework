package com.code041.framework.exception;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

public interface CustomErrorHandlerInterface {

	@ExceptionHandler(EntityNotFoundException.class)
	default ResponseEntity handle(EntityNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	default ResponseEntity handle(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(ValidationErrorRecord::new).toList());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	default ResponseEntity handle(HttpMessageNotReadableException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(BadCredentialsException.class)
	default ResponseEntity handle(BadCredentialsException ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials");
	}

	@ExceptionHandler(AuthenticationException.class)
	default ResponseEntity handle(AuthenticationException ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	}

	@ExceptionHandler(AccessDeniedException.class)
	default ResponseEntity handle(AccessDeniedException ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
	}

	@ExceptionHandler(Exception.class)
	default ResponseEntity handle(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + ex.getLocalizedMessage());
	}

	@ExceptionHandler(BusinessRuleException.class)
	default ResponseEntity handle(BusinessRuleException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
	}

	record ValidationErrorRecord(String campo, String mensagem) {
		public ValidationErrorRecord(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}