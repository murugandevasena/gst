package com.gst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gst.entity.Gst;
import com.gst.service.GstService;

@RestController
@RequestMapping("/gst")
public class GstController {
	@Autowired
	GstService gstService;
	
	@PostMapping("/setOne")
	public String setOne(@RequestBody Gst gst) {
		return gstService.setOne(gst);
	}
	
	@PostMapping("/setMany")
	public String setMany(@RequestBody List<Gst> gst) {
		return gstService.setMany(gst);
	}
	
	@GetMapping("/getById/{id}")
	public Gst getByid(@PathVariable("id") int id ) {
		return gstService.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<Gst> getAll() {
		return gstService.getAll();
	}
	
	@GetMapping("/getByMaxTax")
	public Gst getByMaxTax() {
		return gstService.getByMaxTax();
	}
	
	@GetMapping("/getDisByHsn/{hsn}")
	public int getDisByHsn(@PathVariable("hsn") int hsn) {
		return gstService.getDisByHsn(hsn);
	}
	
	@GetMapping("/getTaxByHsn/{hsn}")
	public int gettaxByHsn(@PathVariable("hsn") int hsn) {
		return gstService.getTaxByHsn(hsn);
	}
	
}
