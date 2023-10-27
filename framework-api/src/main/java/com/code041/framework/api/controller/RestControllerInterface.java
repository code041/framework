package com.code041.framework.api.controller;

import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.api.service.AbstractService;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

public interface RestControllerInterface<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>> {

	AbstractService<MODEL, JPA> getService();

}
