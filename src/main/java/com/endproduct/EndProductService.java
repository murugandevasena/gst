package com.endproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndProductService {
	@Autowired
	EndProductDao endProductDao;

	public String postUpdate(List<EndProduct> endProduct) {
		// TODO Auto-generated method stub
		return endProductDao.postUpdate(endProduct);
		
	}
	

}
