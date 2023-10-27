package com.code041.framework.api.controller;

import com.code041.framework.api.controller.dto.DTOInterface;
import com.code041.framework.api.controller.form.FormInterface;
import com.code041.framework.api.model.JPAEntity;
import com.code041.framework.domain.aggregateroots.AggregateRoot;

public interface CRUDInterface<MODEL extends AggregateRoot, JPA extends JPAEntity<MODEL>, DTO extends DTOInterface<JPA>, FORM extends FormInterface<MODEL, JPA>>
		extends FindById<MODEL, JPA, DTO>, FindAll<MODEL, JPA, DTO>, Save<MODEL, JPA, FORM, DTO>,
		Update<MODEL, JPA, FORM, DTO>, Delete<MODEL, JPA> {

}
