package com.code041.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.code041.framework.domain.model.Model;

public abstract class AbstractRestController<T extends Model> implements RestControllerInterface<T> {

	@Autowired
	private ApplicationEventPublisher publisher;
	

	public ApplicationEventPublisher getEventPublisher() {
		return this.publisher;
	}
	
}
