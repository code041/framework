package com.code041.framework.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.code041.framework.api.controller.dto.DTOInterface;
import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

public interface FindById<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>, DTO extends DTOInterface<JPA>>
		extends RestControllerInterface<MODEL, JPA>, DTOInterface<JPA> {

	@GetMapping("/{id}")
	default ResponseEntity<DTO> findById(@PathVariable final Long id) {
		JPA managedJpaEntity = getService().findById(id);
		var dto = toDTO(managedJpaEntity);
		return ResponseEntity.ok(dto);
	}

	public abstract DTO toDTO(JPA jpaEntity);

}
