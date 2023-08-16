package com.endproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EndProductDao {
	@Autowired
	EndProductRepository endProductRepository;

	public String postUpdate(List<EndProduct> endProduct) {
		// TODO Auto-generated method stub
		endProductRepository.saveAll(endProduct);
		return "Updated successfully";
	}

}
