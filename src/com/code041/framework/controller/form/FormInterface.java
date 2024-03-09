package com.code041.framework.controller.form;

import com.code041.framework.domain.model.Model;

public interface FormInterface<T extends Model> {

	public abstract T map();
	
}
