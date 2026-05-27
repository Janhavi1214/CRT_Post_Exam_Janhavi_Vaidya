package com.postExam.Flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postExam.Flight.entity.Flight;
import com.postExam.Flight.service.FlightService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

	@Autowired
    private FlightService service;


    @GetMapping(value = "/{code}")
    public ResponseEntity<Flight> findByCode(@PathVariable int code) {
    	Flight flight = service.findByCode(code);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping(value = "/carrier/{carrier}")
    public ResponseEntity<List<Flight>> findByCarrier(@PathVariable String carrier) {
        List<Flight> flight = service.findByCarrier(carrier);
        if(flight.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(flight, HttpStatus.OK);
        }
    }


    @GetMapping(value = "/price")
    public ResponseEntity<List<Flight>> findByPriceRange(@RequestParam double min, @RequestParam double max) {
        List<Flight> flight = service.findByPriceRange(min, max);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
    
    @GetMapping(value = "/route")
    public ResponseEntity<List<Flight>> findByRoute(@RequestParam String source, @RequestParam String destination) {
        List<Flight> flight = service.findByRoute(source, destination);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Flight>> getFlights() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Flight> save(@RequestBody Flight f){
        return new ResponseEntity<>(service.save(f), HttpStatus.CREATED);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteByCode(@PathVariable int code) {
        if(service.deleteByCode(code))
            return new ResponseEntity<>("Flight deleted", HttpStatus.OK);
        else
            return new ResponseEntity<>("Flight not found",  HttpStatus.NOT_FOUND);
    }
}
