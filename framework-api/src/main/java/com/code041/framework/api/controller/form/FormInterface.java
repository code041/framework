package com.code041.framework.api.controller.form;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;

import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

public interface FormInterface<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>> {

	public abstract JPA toJPAEntity();

	default MODEL toModel(FormInterface<MODEL, JPA> form, Class<MODEL> clazz) {
		var mapper = new ModelMapper().registerModule(new RecordModule());
		MODEL map = mapper.map(form, clazz);
		return map;
	}

}
