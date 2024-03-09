package com.code041.framework.domain.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.code041.framework.domain.model.Model;
import com.code041.framework.domain.service.AbstractService;
import com.code041.framework.domain.usecase.businessrule.BusinessRuleInterface;

public abstract class AbstractUseCase<T extends Model> {
//
//	@Autowired
//	protected AbstractService<T> service;
//
//	@Autowired
//	private List<BusinessRuleInterface<T>> constraints;
//
//	public T execute(T t) {
//		check(t);
//		return specs(t);
//	}
//
//	private void check(T t) {
//		this.constraints.stream().forEach(rule -> {
//			rule.check(t);
//		});
//	}
//
//	protected abstract T specs(T t);

}
