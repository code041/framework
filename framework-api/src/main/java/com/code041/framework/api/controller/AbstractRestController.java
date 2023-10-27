package com.code041.framework.api.controller;

import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

public abstract class AbstractRestController<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>>
		implements RestControllerInterface<MODEL, JPA> {

}
