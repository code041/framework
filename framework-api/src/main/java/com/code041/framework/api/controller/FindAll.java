package com.code041.framework.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.code041.framework.api.controller.dto.DTOInterface;
import com.code041.framework.api.controller.dto.PageDTOInterface;
import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

public interface FindAll<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>, DTO extends DTOInterface<JPA>>
		extends RestControllerInterface<MODEL, JPA>, DTOInterface<JPA>, PageDTOInterface<JPA> {

	@GetMapping
	default ResponseEntity<Page<DTOInterface<JPA>>> findAll(
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {
		Page<JPA> page = getService().findAll(pageable);
		Page<DTOInterface<JPA>> pageDTO = toPageDTO(page);
		return ResponseEntity.ok(pageDTO);
	}

}
