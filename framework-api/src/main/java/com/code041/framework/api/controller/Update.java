package com.code041.framework.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.code041.framework.api.controller.dto.DTOInterface;
import com.code041.framework.api.controller.form.FormInterface;
import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

import jakarta.transaction.Transactional;

public interface Update<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>, FORM extends FormInterface<MODEL, JPA>, DTO extends DTOInterface<JPA>>
		extends RestControllerInterface<MODEL, JPA> {

	@PutMapping("/{id}")
	@Transactional
	default ResponseEntity<DTO> update(@PathVariable final Long id, @RequestBody FORM form) {
		JPA jpaEntity = form.toJPAEntity();
		getService().update(id, jpaEntity);
		return ResponseEntity.ok().build();
	}

}
