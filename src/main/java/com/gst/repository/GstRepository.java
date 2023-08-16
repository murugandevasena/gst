package com.gst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gst.entity.Gst;

public interface GstRepository extends JpaRepository<Gst, Integer> {

	@Query(value="select discount from gst_details where hsn=?",nativeQuery=true)
	int getDisByHsn(int hsn);

	@Query(value ="select tax from gst_details where hsn=?",nativeQuery=true)
	int getTaxByHsn(int hsn);

}
