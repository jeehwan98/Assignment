package com.ohgiraffers.springdatajpa.main.menu.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "info_airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_no")
    private int airlineNo;          // 항공번호 (FK)
                                    // 1 : 대한항공
                                    // 2 : 아시아나 항공
    @Column(name = "airline_name")
    private String airlineName;    // 항공 이름

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights = new ArrayList<>();

    protected Airline() {}

    public Airline(int airlineNo, String airlineName, List<Flight> flights) {
        this.airlineNo = airlineNo;
        this.airlineName = airlineName;
        this.flights = flights;
    }

    public int getAirlineNo() {
        return airlineNo;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineNo=" + airlineNo +
                ", airlineName='" + airlineName + '\'' +
                ", flights=" + flights +
                '}';
    }
}
