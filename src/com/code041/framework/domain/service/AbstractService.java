package com.code041.framework.domain.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.code041.framework.domain.model.Model;

import jakarta.persistence.EntityNotFoundException;

public abstract class AbstractService<T extends Model> {

	protected abstract JpaRepository<T, Long> getRepository();

	public final T findById(final Long id) {
		Optional<T> optional = getRepository().findById(id);
		if (optional.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optional.get();
	}

	public final Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	protected final void save(T entity) {
		getRepository().save(entity);
	}

	protected final void update(Long id, T entity) {
		T managedJpaEntity = this.findById(id);
		getRepository().save(managedJpaEntity);
	}

	protected final void delete(Long id) {
		T managedJpaEntity = this.findById(id);
		getRepository().delete(managedJpaEntity);
	}
}
