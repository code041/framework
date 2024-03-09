package com.code041.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.code041.framework.domain.model.JPAEntity;

public abstract class AbstractRestController<T extends JPAEntity> implements RestControllerInterface<T> {

	@Autowired
	private ApplicationEventPublisher publisher;

	public ApplicationEventPublisher getEventPublisher() {
		return this.publisher;
	}

}
