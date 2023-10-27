package com.code041.framework.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.code041.framework.api.model.JPAEntity;

public interface PageDTOInterface<JPA extends JPAEntity<?>> extends DTOInterface<JPA> {

	default <DTO extends DTOInterface<JPA>> Page<DTOInterface<JPA>> toPageDTO(Page<JPA> page) {
		List<DTOInterface<JPA>> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
		return new PageImpl<>(content);
	}

}
