package com.code041.framework.controller.form;

import com.code041.framework.domain.model.JPAEntity;

public interface FormInterface<T extends JPAEntity> {

	public abstract T map();

}
