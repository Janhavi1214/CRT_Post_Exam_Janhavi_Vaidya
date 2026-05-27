package com.postExam.Flight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.postExam.Flight.entity.Flight;
import com.postExam.Flight.repo.FlightRepo;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFlightRepo {

    @Autowired
    private FlightRepo repo;

    @Test
    public void testFindByCode() {
        Optional<Flight> entity = repo.findById(101);

        assertTrue(entity.isPresent());
        assertEquals("Indigo", entity.get().getCarrier());
    }

    @Test
    @DisplayName("Test 1 : Save Flight Test")
    @Order(1)
    public void testSave() {

        Flight flight = new Flight();

        flight.setCode(999);
        flight.setCarrier("Air India");
        flight.setSource("Nagpur");
        flight.setDestination("Pune");
        flight.setCost(4500);

        Flight savedEntity = repo.save(flight);

        assertNotNull(savedEntity);
    }

    @Test
    @Order(2)
    public void testFindById() {

        Flight flight = repo.findById(999).get();

        assertNotNull(flight);
    }

    @Test
    @Order(3)
    public void testFindAll() {

        List<Flight> flights = repo.findAll();

        assertTrue(flights.size() > 0);
    }

    @Test
    @Order(4)
    public void testFindByCarrier() {

        List<Flight> flights = repo.findByCarrier("Indigo");

        assertTrue(flights.size() > 0);
    }

    @Test
    @Order(5)
    public void testFindByPriceRange() {

        List<Flight> flights = repo.findByPriceRange(2000, 6000);

        assertTrue(flights.size() > 0);
    }

    @Test
    @Order(6)
    public void testFindByRoute() {

        List<Flight> flights =
                repo.findByRoute("Mumbai", "Delhi");

        assertTrue(flights.size() > 0);
    }

    @Test
    @Order(7)
    public void testDelete() {

        repo.deleteById(999);

        Optional<Flight> flight = repo.findById(999);

        assertTrue(flight.isEmpty());
    }
}