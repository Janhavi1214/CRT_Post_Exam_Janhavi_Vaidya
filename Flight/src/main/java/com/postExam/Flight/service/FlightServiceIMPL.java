package com.postExam.Flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postExam.Flight.entity.Flight;
import com.postExam.Flight.repo.FlightRepo;

@Service
public class FlightServiceIMPL implements FlightService {

    @Autowired
    private FlightRepo repo;

    @Override
    public Flight save(Flight f) {
        return repo.save(f);
    }

    @Override
    public Flight findByCode(int code) {
        return repo.findById(code).orElse(null);
    }

    @Override
    public List<Flight> findByCarrier(String carrier) {
        return (List<Flight>) repo.findByCarrier(carrier);
    }

    @Override
    public List<Flight> findByRoute(String source, String destination) {
        return repo.findByRoute(source, destination);
    }

    @Override
    public List<Flight> findByPriceRange(double min, double max) {
        return repo.findByPriceRange(min, max);
    }

    @Override
    public List<Flight> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean deleteByCode(int code) {
        repo.deleteById(code);
        return true;
    }
}