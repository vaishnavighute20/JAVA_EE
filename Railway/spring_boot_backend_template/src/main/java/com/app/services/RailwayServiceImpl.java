package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.RailwayDTO;
import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.exception.InvildCredentialException;
import com.app.repository.RailwayRepository;

 
@Service
@Transactional
public class RailwayServiceImpl implements RailwayServices {

	@Autowired
	private RailwayRepository railwayRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Railway> getDetails() {
 		return railwayRepository.findAll() ;
	}
 
	@Override
	public Railway addDetails(Railway railway) {
		// TODO Auto-generated method stub
		return railwayRepository.save(railway);
	}

	@Override
	public Railway updateDetails(Railway railway) {
		// TODO Auto-generated method stub
		return railwayRepository.save(railway);
	}
	

	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		if(railwayRepository.existsById(id)) {
			railwayRepository.deleteById(id);
			return "Deleted Succesfully";
		}
		return "Invalid id";
	}

	@Override
	public Railway getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Railway> optional=railwayRepository.findById(id);
		return optional.orElseThrow(()->new InvildCredentialException("inavlid Id"));
	}

	@Override
	public List<RailwayDTO> getAllDetails() {
		List<Railway> rail=railwayRepository.findAll();
		List<RailwayDTO> raildto=new ArrayList<RailwayDTO>();
		for(Railway r:rail) {
			raildto.add(mapper.map(r,RailwayDTO.class));
 		}
		return raildto;
	}

	@Override
	public List<Railway> getDetailCategory(Category category) {
		
		return railwayRepository.findByCategory(category);
	}
	
	
	
	

}
