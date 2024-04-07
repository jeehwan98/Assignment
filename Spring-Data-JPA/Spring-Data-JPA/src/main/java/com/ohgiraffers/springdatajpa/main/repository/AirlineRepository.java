package com.ohgiraffers.springdatajpa.main.repository;

import com.ohgiraffers.springdatajpa.main.menu.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
