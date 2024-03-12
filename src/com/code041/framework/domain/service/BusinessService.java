package com.code041.framework.domain.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.code041.framework.domain.model.JPAEntity;

import jakarta.persistence.EntityNotFoundException;

public abstract class BusinessService<T extends JPAEntity> {

	protected JpaRepository<T, Long> repository;

	public BusinessService(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}

	public final T findById(final Long id) {
		Optional<T> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optional.get();
	}

	public final Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public final void save(T entity) {
		repository.save(entity);
	}

	public final void update(Long id, T entity) {
		T managedJpaEntity = this.findById(id);
		repository.save(managedJpaEntity);
	}

	public final void delete(Long id) {
		T managedJpaEntity = this.findById(id);
		repository.delete(managedJpaEntity);
	}

}
