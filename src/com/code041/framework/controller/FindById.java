package com.code041.framework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.code041.framework.controller.dto.DataTransferObject;
import com.code041.framework.domain.model.JPAEntity;

public interface FindById<MODEL extends JPAEntity> extends RestControllerInterface<MODEL>, DataTransferObject<MODEL> {

	@GetMapping("/{id}")
	default ResponseEntity<DataTransferObject<MODEL>> findById(@PathVariable final Long id) {
		MODEL entity = getService().findById(id);
		var dto = map(entity);
		return ResponseEntity.ok(dto);
	}

}
