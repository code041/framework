package com.code041.framework.domain.usecase.businessrule;

import com.code041.framework.exception.BusinessRuleException;

@FunctionalInterface
public interface BusinessRuleInterface<T> {

	void check(T t) throws BusinessRuleException;

}
