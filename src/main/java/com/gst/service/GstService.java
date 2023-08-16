package com.gst.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gst.dao.GstDao;
import com.gst.entity.Gst;

@Service
public class GstService {

	@Autowired
	GstDao gstDao;
	public String setOne(Gst gst) {
		// TODO Auto-generated method stub
		return gstDao.setOne(gst);
	}
	public String setMany(List<Gst> gst) {
		// TODO Auto-generated method stub
		return gstDao.setMany(gst);
	}
	public Gst getById(int id) {
		// TODO Auto-generated method stub
		return gstDao.getById(id);
	}
	public List<Gst> getAll() { 
		// TODO Auto-generated method stub
		return gstDao.getAll();
	}
	public Gst getByMaxTax() {
		// TODO Auto-generated method stub
		List<Gst> l1 = getAll();
		Gst l2 = l1.stream().max(Comparator.comparingInt(Gst::getTax)).get();
		return l2;
	}
	public int getDisByHsn(int hsn) {
		// TODO Auto-generated method stub
		return gstDao.getDisByHsn(hsn);
	}
	public int getTaxByHsn(int hsn) {
		// TODO Auto-generated method stub
		return gstDao.getTaxByHsn(hsn);
	}
	
}
