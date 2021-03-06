package com.laptrinhjavaweb.repository.custom;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> findAll(Map<String, Object> properties, Pageable pageable, BuildingSearchBuilder fieldSearch);
	
	List<BuildingEntity> findAll(Map<String, Object> properties, BuildingSearchBuilder fieldSearch);
	
	List<BuildingEntity> findAllByStaff(Map<String, Object> properties, Pageable pageable, BuildingSearchBuilder fieldSearch);
	
	void deleteProperties(Long id);
}
