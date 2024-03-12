package com.code041.framework.controller.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.code041.framework.domain.model.JPAEntity;

public interface DataTransferObject<T extends JPAEntity> {

	DataTransferObject<T> map(T entity);

	default Page<DataTransferObject<T>> map(Page<T> page) {
		List<DataTransferObject<T>> content = page.getContent().stream().map(this::map).collect(Collectors.toList());
		return new PageImpl<DataTransferObject<T>>(content);
	}

	default Set<DataTransferObject<T>> map(Set<T> set) {
		return set.stream().map(this::map).collect(Collectors.toSet());
	}

}
