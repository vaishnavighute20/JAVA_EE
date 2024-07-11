package com.app.services;

import java.util.List;

import com.app.dto.RailwayDTO;
import com.app.entity.Category;
import com.app.entity.Railway;

public interface RailwayServices {
	
	List<Railway> getDetails();

	Railway addDetails(Railway railway);

	Railway updateDetails(Railway railway);
	
	String delete(Long id);

	Railway getById(Long id);

	List<RailwayDTO> getAllDetails();

	List<Railway> getDetailCategory(Category category);

}
