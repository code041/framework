package com.code041.framework.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

import jakarta.transaction.Transactional;

public interface Delete<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>>
		extends RestControllerInterface<MODEL, JPA> {

	@DeleteMapping("/{id}")
	@Transactional
	default ResponseEntity<?> delete(@PathVariable final Long id) {
		getService().delete(id);
		return ResponseEntity.ok().build();
	}

}
