package com.code041.framework.api.model;

import com.code041.framework.domain.aggregateroots.AggregateRoot;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * An Entity is a persistent representation of a domain model.
 * 
 * @param <MODEL>
 */

@Getter
@Setter
@MappedSuperclass
public abstract class JPAEntity<MODEL extends AggregateRoot> {

	protected static final String SEQUENCE_GENERATOR = "SEQUENCE_GENERATOR";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR)
	@Column(name = "ID")
	protected Long id;

	public abstract MODEL toDomainModel();

}
