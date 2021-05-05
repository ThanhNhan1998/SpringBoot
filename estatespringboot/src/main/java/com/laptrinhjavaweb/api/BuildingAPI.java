package com.laptrinhjavaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

	@Autowired
	private IBuildingService buildingService;

	@GetMapping
	public List<BuildingDTO> showBuilding(@RequestParam Map<String, String> model,
			@RequestParam String[] buildingTypes) {
		
		BuildingSearchBuilder fieldSearchBuilder = new BuildingSearchBuilder.Builder().setName(model.get("name"))
				.setDistrict(model.get("district")).setBuildingArea(model.get("buildingArea"))
				.setNumberOfBasement(model.get("numberOfBasement")).setCostRentFrom(model.get("costRentFrom"))
				.setCostRentTo(model.get("costRentTo")).setAreaRentFrom(model.get("areaRentFrom"))
				.setAreaRentTo(model.get("areaRentTo")).setBuildingTypes(buildingTypes)
				.setStaffId(model.get("staffId")).build();
		
		Pageable pageable = PageRequest.of(Integer.parseInt(model.get("page")) - 1, Integer.parseInt(model.get("limit")));
		
		List<BuildingDTO> buildings = buildingService.findAll(fieldSearchBuilder, pageable);
		
		return buildings;
	}
	
	@GetMapping("/types")
	public Map<String, String> getBuildingTypes(){
		
		return buildingService.getBuildingTypes();
	}
	
	@PostMapping
	public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {

		return buildingService.save(newBuilding);
	}

	@PutMapping
	public void updateBuilding(@RequestBody BuildingDTO building) {

		buildingService.update(building);
	}

	@DeleteMapping
	public void deleteBuilding(@RequestBody BuildingDTO building) {

		buildingService.delete(building.getIds());
	}
}
