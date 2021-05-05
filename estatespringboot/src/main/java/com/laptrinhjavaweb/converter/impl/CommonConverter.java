package com.laptrinhjavaweb.converter.impl;

import java.lang.reflect.ParameterizedType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.laptrinhjavaweb.converter.IConverter;

public class CommonConverter<D, E> implements IConverter<D, E>{
	
	@Autowired
	private ModelMapper mapper;
	
	private Class<D> dClass;
	private Class<E> eClass;
	
	@SuppressWarnings("unchecked")
	public CommonConverter() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		dClass = (Class<D>) parameterizedType.getActualTypeArguments()[0];
		eClass = (Class<E>) parameterizedType.getActualTypeArguments()[1];
	}
	
	@Override
	public D convertToDTO(E entity) {
		
		return (D) mapper.map(entity, this.dClass);
	}

	@Override
	public E convertToEntity(D dto) {
		
		return (E) mapper.map(dto, this.eClass);
	}

}
