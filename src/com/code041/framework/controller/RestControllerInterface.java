package com.code041.framework.controller;

import org.springframework.context.ApplicationEventPublisher;

import com.code041.framework.domain.model.JPAEntity;
import com.code041.framework.domain.service.AbstractService;

public interface RestControllerInterface<T extends JPAEntity> {

	AbstractService<T> getService();
	
	ApplicationEventPublisher getEventPublisher();
}
