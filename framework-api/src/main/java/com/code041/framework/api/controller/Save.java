package com.code041.framework.api.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.code041.framework.api.controller.dto.DTOInterface;
import com.code041.framework.api.controller.form.FormInterface;
import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

import jakarta.transaction.Transactional;

public interface Save<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>, FORM extends FormInterface<MODEL, JPA>, DTO extends DTOInterface<JPA>>
		extends RestControllerInterface<MODEL, JPA>, DTOInterface<JPA> {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	default ResponseEntity<DTOInterface<JPA>> save(@RequestBody FORM form, UriComponentsBuilder uriBuilder) {
		JPA jpaEntity = form.toJPAEntity();
		getService().save(jpaEntity);
		URI uri = uriBuilder.path(getPath() + "/{id}").buildAndExpand(jpaEntity.getId()).toUri();
		DTOInterface<JPA> dto = toDTO(jpaEntity);
		return ResponseEntity.created(uri).body(dto);
	}

	abstract String getPath();

}
