package com.code041.framework.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

import jakarta.persistence.EntityNotFoundException;

@Service
public abstract class AbstractService<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>> {

	@Autowired
	protected JpaRepository<JPA, Long> repository;

	public final JPA findById(final Long id) {
		Optional<JPA> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optional.get();
	}

	public final Page<JPA> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public final void save(JPA jpaEntity) {
		MODEL domainModel = jpaEntity.toDomainModel();
		save(domainModel);
		repository.save(jpaEntity);
	}

	protected void save(MODEL model) {
	}

	public final void update(Long id, JPA jpaEntity) {
		JPA managedJpaEntity = this.findById(id);
		update(managedJpaEntity.toDomainModel());
		repository.save(managedJpaEntity);
	}

	protected void update(MODEL model) {

	}

	public final void delete(Long id) {
		JPA managedJpaEntity = this.findById(id);
		delete(managedJpaEntity.toDomainModel());
		repository.delete(managedJpaEntity);
	}

	protected void delete(MODEL model) {

	}
}
