package com.code041.framework.controller;

import org.springframework.context.ApplicationEventPublisher;

import com.code041.framework.domain.model.Model;
import com.code041.framework.domain.service.AbstractService;

public interface RestControllerInterface<T extends Model> {

	AbstractService<T> getService();
	
	ApplicationEventPublisher getEventPublisher();
}
