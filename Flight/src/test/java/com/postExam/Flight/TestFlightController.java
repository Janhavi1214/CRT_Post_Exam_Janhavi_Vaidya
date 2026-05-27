package com.postExam.Flight;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.postExam.Flight.controller.FlightController;
import com.postExam.Flight.entity.Flight;
import com.postExam.Flight.service.FlightServiceIMPL;

@WebMvcTest(FlightController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFlightController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightServiceIMPL service;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @Order(1)
    public void testSaveFlight() throws Exception {

        Flight flight = new Flight();

        flight.setCode(101);
        flight.setCarrier("Indigo");
        flight.setSource("Mumbai");
        flight.setDestination("Delhi");
        flight.setCost(4500);

        when(service.save(flight)).thenReturn(flight);

        mockMvc.perform(
                post("/flight")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(flight))
        ).andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void testFindByCode() throws Exception {

        Flight flight = new Flight();

        flight.setCode(101);
        flight.setCarrier("Indigo");
        flight.setSource("Mumbai");
        flight.setDestination("Delhi");
        flight.setCost(4500);

        when(service.findByCode(101)).thenReturn(flight);

        mockMvc.perform(
                get("/flight/101")
        ).andExpect(status().isOk());
    }

    @Test
    @Order(3)
    public void testFindAll() throws Exception {

        Flight f1 = new Flight();
        f1.setCode(101);
        f1.setCarrier("Indigo");
        f1.setSource("Mumbai");
        f1.setDestination("Delhi");
        f1.setCost(4500);

        Flight f2 = new Flight();
        f2.setCode(102);
        f2.setCarrier("Air India");
        f2.setSource("Nagpur");
        f2.setDestination("Pune");
        f2.setCost(3500);

        when(service.findAll()).thenReturn(List.of(f1, f2));

        mockMvc.perform(
                get("/flight/all")
        ).andExpect(status().isOk());
    }

    @Test
    @Order(4)
    public void testFindByCarrier() throws Exception {

        Flight flight = new Flight();

        flight.setCode(101);
        flight.setCarrier("Indigo");
        flight.setSource("Mumbai");
        flight.setDestination("Delhi");
        flight.setCost(4500);

        when(service.findByCarrier("Indigo"))
                .thenReturn(List.of(flight));

        mockMvc.perform(
                get("/flight/carrier/Indigo")
        ).andExpect(status().isOk());
    }

    @Test
    @Order(5)
    public void testFindByPriceRange() throws Exception {

        Flight flight = new Flight();

        flight.setCode(101);
        flight.setCarrier("Indigo");
        flight.setSource("Mumbai");
        flight.setDestination("Delhi");
        flight.setCost(4500);

        when(service.findByPriceRange(2000, 5000))
                .thenReturn(List.of(flight));

        mockMvc.perform(
                get("/flight/price/2000/5000")
        ).andExpect(status().isOk());
    }

    @Test
    @Order(6)
    public void testFindByRoute() throws Exception {

        Flight flight = new Flight();

        flight.setCode(101);
        flight.setCarrier("Indigo");
        flight.setSource("Mumbai");
        flight.setDestination("Delhi");
        flight.setCost(4500);

        when(service.findByRoute("Mumbai", "Delhi"))
                .thenReturn(List.of(flight));

        mockMvc.perform(
                get("/flight/route/Mumbai/Delhi")
        ).andExpect(status().isOk());
    }

    @Test
    @Order(7)
    public void testDelete() throws Exception {

        mockMvc.perform(
                delete("/flight/101")
        ).andExpect(status().isOk());
    }
}