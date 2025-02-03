package com.dhagakart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhagakart.entity.Commodity;

public interface CommodityRepo extends JpaRepository<Commodity, Long> {

	public List<Commodity> findByVariant(String variant);
	
	
	
	
	

}
