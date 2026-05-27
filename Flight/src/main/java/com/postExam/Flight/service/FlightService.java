package com.postExam.Flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.postExam.Flight.entity.Flight;

@Service
public interface FlightService {

	Flight save(Flight f);
	
	Flight findByCode(int code);
	
	List<Flight> findByCarrier(String carrier);
	
	List<Flight> findByRoute(String source, String destination);
	
	List<Flight> findByPriceRange(double min, double max);
	
	List<Flight> findAll();
	
	boolean deleteByCode(int code);
}
