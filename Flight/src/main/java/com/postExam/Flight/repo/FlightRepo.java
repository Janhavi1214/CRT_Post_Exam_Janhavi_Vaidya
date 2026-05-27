package com.postExam.Flight.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.postExam.Flight.entity.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {

    List<Flight> findByCarrier(String carrier);

    @Query("FROM Flight WHERE source = :src AND destination = :dest")
    List<Flight> findByRoute(@Param("src") String source,
                             @Param("dest") String destination);

    @Query("FROM Flight WHERE cost BETWEEN :min AND :max")
    List<Flight> findByPriceRange(@Param("min") double min,
                                  @Param("max") double max);
}