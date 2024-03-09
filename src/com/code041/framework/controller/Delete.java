package com.code041.framework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.code041.framework.domain.model.Model;

public interface Delete<MODEL extends Model> extends RestControllerInterface<MODEL> {

	@DeleteMapping("/{id}")
	@Transactional
	default ResponseEntity<?> delete(@PathVariable final Long id) {
		getEventPublisher().publishEvent(id);
		//getService().delete(id);
		return ResponseEntity.ok().build();
	}
	
}
