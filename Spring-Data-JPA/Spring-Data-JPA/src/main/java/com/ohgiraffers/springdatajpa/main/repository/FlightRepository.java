package com.ohgiraffers.springdatajpa.main.repository;

import com.ohgiraffers.springdatajpa.main.menu.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
