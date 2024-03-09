package com.code041.framework.controller.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.code041.framework.domain.model.JPAEntity;

public interface DTOInterface<T extends JPAEntity> {

	DTOInterface<T> map(T entity);

	default Page<DTOInterface<T>> map(Page<T> page) {
		List<DTOInterface<T>> content = page.getContent().stream().map(this::map).collect(Collectors.toList());
		return new PageImpl<DTOInterface<T>>(content);
	}

	default Set<DTOInterface<T>> map(Set<T> set) {
		return set.stream().map(this::map).collect(Collectors.toSet());
	}

}
