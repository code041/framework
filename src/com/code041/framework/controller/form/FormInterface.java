package com.code041.framework.controller.form;

import com.code041.framework.domain.model.JPAEntity;

public interface FormInterface<T extends JPAEntity> {

	public abstract T map();

	/*
	 * public interface FormInterface<MODEL 
extends AggregateRoot, JPA extends JPAEntity<MODEL>> {

	public abstract JPA toJPAEntity();

	default MODEL toModel(FormInterface<MODEL, JPA> form, Class<MODEL> clazz) {
		var mapper = new ModelMapper().registerModule(new RecordModule());
		MODEL map = mapper.map(form, clazz);
		return map;
	}

}
	 */
}
