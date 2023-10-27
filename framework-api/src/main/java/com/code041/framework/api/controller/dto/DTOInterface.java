package com.code041.framework.api.controller.dto;

import com.code041.framework.api.model.JPAEntity;

public interface DTOInterface<JPA extends JPAEntity<?>> {

	DTOInterface<JPA> toDTO(JPA jpaEntity);

}
