package com.code041.framework.domain.usecase;

import java.util.List;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.repository.JpaRepository;

import com.code041.framework.domain.model.JPAEntity;
import com.code041.framework.domain.service.BusinessService;
import com.code041.framework.domain.usecase.businessrule.BusinessRule;

public abstract class UseCase<T extends JPAEntity, E extends ApplicationEvent> extends BusinessService<T>
		implements ApplicationListener<E> {

	private List<BusinessRule<E>> rules;

	public UseCase(JpaRepository<T, Long> repository, List<BusinessRule<E>> rules) {
		super(repository);
		this.rules = rules;
	}

	private void check(E event) {
		System.out.println(this.rules.size());
		
		this.rules.stream().forEach(rule -> {
			rule.check(event);
		});
	}

	@Override
	public void onApplicationEvent(E event) {
		check(event);
		specs(event);
	}

	protected abstract void specs(E event);

}
