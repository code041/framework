package com.code041.framework.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.code041.framework.controller.dto.DataTransferObject;
import com.code041.framework.controller.form.FormInterface;
import com.code041.framework.domain.model.JPAEntity;

public interface Update<MODEL extends JPAEntity, FORM extends FormInterface<MODEL>, DTO extends DataTransferObject<MODEL>>
		extends RestControllerInterface<MODEL> {

	@PutMapping("/{id}")
	@Transactional
	default ResponseEntity<DTO> update(@PathVariable final Long id, @RequestBody FORM form) {
		MODEL jpaEntity = form.map();
		getService().update(id, jpaEntity);
		return ResponseEntity.ok().build();
	}

	abstract ModelMapper update();

}