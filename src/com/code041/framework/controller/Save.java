package com.code041.framework.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.code041.framework.controller.dto.DataTransferObject;
import com.code041.framework.controller.form.FormInterface;
import com.code041.framework.domain.model.JPAEntity;

public interface Save<MODEL extends JPAEntity, FORM extends FormInterface<MODEL>, DTO extends DataTransferObject<MODEL>>
		extends RestControllerInterface<MODEL>, DataTransferObject<MODEL> {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	default ResponseEntity<DataTransferObject<MODEL>> save(@RequestBody FORM form, UriComponentsBuilder uriBuilder) {
		MODEL entity = form.map();
		URI uri = uriBuilder.path(path() + "/{id}").buildAndExpand(entity.getId()).toUri();
		DataTransferObject<MODEL> dto = map(entity);
		return ResponseEntity.created(uri).body(dto);
	}

	abstract String path();

}
