package com.code041.framework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.code041.framework.controller.dto.DTOInterface;
import com.code041.framework.domain.model.Model;

public interface FindById<MODEL extends Model> extends RestControllerInterface<MODEL>, DTOInterface<MODEL> {

	@GetMapping("/{id}")
	default ResponseEntity<DTOInterface<MODEL>> findById(@PathVariable final Long id) {
		MODEL entity = getService().findById(id);
		var dto = map(entity);
		return ResponseEntity.ok(dto);
	}

}
