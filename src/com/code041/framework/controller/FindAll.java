package com.code041.framework.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.code041.framework.controller.dto.DTOInterface;
import com.code041.framework.domain.model.JPAEntity;

public interface FindAll<MODEL extends JPAEntity> extends RestControllerInterface<MODEL>, DTOInterface<MODEL> {

	@GetMapping
	default ResponseEntity<Page<DTOInterface<MODEL>>> findAll(
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {
		Page<MODEL> page = getService().findAll(pageable);
		var pageDTO = map(page);
		return ResponseEntity.ok(pageDTO);
	}

}
