package com.gst.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gst.entity.Gst;
import com.gst.repository.GstRepository;

@Repository
public class GstDao {

	@Autowired
	GstRepository gstRepository;
	public String setOne(Gst gst) {
		// TODO Auto-generated method stub
		 gstRepository.save(gst);
		 return "Gst detail saved successfully";
	}
	public String setMany(List<Gst> gst) {
		// TODO Auto-generated method stub
		gstRepository.saveAll(gst);
		return "Gst details saved successfully";
	}
	public Gst getById(int id) {
		// TODO Auto-generated method stub
		return gstRepository.findById(id).get();
	}
	public List<Gst> getAll() {
		// TODO Auto-generated method stub
		return gstRepository.findAll();
	}
	public int getDisByHsn(int hsn) {
		// TODO Auto-generated method stub
		return gstRepository.getDisByHsn(hsn);
	}
	public int getTaxByHsn(int hsn) {
		// TODO Auto-generated method stub
		return gstRepository.getTaxByHsn(hsn);
	}

}
