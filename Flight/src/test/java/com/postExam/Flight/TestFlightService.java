package com.postExam.Flight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.postExam.Flight.entity.Flight;
import com.postExam.Flight.repo.FlightRepo;
import com.postExam.Flight.service.FlightServiceIMPL;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFlightService {

    @Mock
    private FlightRepo repo;

    @InjectMocks
    private FlightServiceIMPL service;

    private Flight flight1, flight2;

    @BeforeEach
    public void setUp() {

        flight1 = new Flight();
        flight1.setCode(101);
        flight1.setCarrier("Indigo");
        flight1.setSource("Mumbai");
        flight1.setDestination("Delhi");
        flight1.setCost(4500);

        flight2 = new Flight();
        flight2.setCode(102);
        flight2.setCarrier("Air India");
        flight2.setSource("Nagpur");
        flight2.setDestination("Pune");
        flight2.setCost(3500);
    }

    @Test
    @Order(1)
    public void testSaveFlight() {

        given(repo.save(flight1)).willReturn(flight1);

        Flight savedFlight = service.save(flight1);

        assertNotNull(savedFlight);
    }

    @Test
    @Order(2)
    public void testFindByCode() {

        given(repo.findById(101))
                .willReturn(Optional.of(flight1));

        Flight result = service.findByCode(101);

        assertNotNull(result);
    }

    @Test
    @Order(3)
    public void testFindAll() {

        given(repo.findAll())
                .willReturn(List.of(flight1, flight2));

        List<Flight> flights = service.findAll();

        assertEquals(2, flights.size());
    }

    @Test
    @Order(4)
    public void testFindByCarrier() {

        given(repo.findByCarrier("Indigo"))
                .willReturn(List.of(flight1));

        List<Flight> flights =
                service.findByCarrier("Indigo");

        assertEquals(1, flights.size());
    }

    @Test
    @Order(5)
    public void testFindByPriceRange() {

        given(repo.findByPriceRange(2000, 5000))
                .willReturn(List.of(flight1, flight2));

        List<Flight> flights =
                service.findByPriceRange(2000, 5000);

        assertEquals(2, flights.size());
    }

    @Test
    @Order(6)
    public void testFindByRoute() {

        given(repo.findByRoute("Mumbai", "Delhi"))
                .willReturn(List.of(flight1));

        List<Flight> flights =
                service.findByRoute("Mumbai", "Delhi");

        assertEquals(1, flights.size());
    }

    @Test
    @Order(7)
    public void testDelete() {

        willDoNothing().given(repo)
                .deleteById(flight1.getCode());

        service.deleteByCode(flight1.getCode());

        verify(repo, times(1))
                .deleteById(flight1.getCode());
    }
}