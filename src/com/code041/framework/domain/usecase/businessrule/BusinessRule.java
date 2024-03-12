package com.code041.framework.domain.usecase.businessrule;

import org.springframework.context.ApplicationEvent;

import com.code041.framework.exception.BusinessRuleException;

@FunctionalInterface
public interface BusinessRule<E extends ApplicationEvent> {

	void check(E event) throws BusinessRuleException;

}
