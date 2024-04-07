package com.ohgiraffers.springdatajpa.main.menu.DTO;

import com.ohgiraffers.springdatajpa.main.menu.entity.Flight;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class AirlineDTO {

    private int airlineNo;          // 항공번호 (FK)
    // 1 : 대한항공
    // 2 : 아시아나 항공
    private String airlineName;    // 항공 이름

    private List<FlightDTO> flights = new ArrayList<>(); // 항공사의 비행 정보

    public AirlineDTO() {}

    public AirlineDTO(int airlineNo, String airlineName, List<FlightDTO> flights) {
        this.airlineNo = airlineNo;
        this.airlineName = airlineName;
        this.flights = flights;
    }

    public int getAirlineNo() {
        return airlineNo;
    }

    public void setAirlineNo(int airlineNo) {
        this.airlineNo = airlineNo;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<FlightDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDTO> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineNo=" + airlineNo +
                ", airline_name='" + airlineName + '\'' +
                ", flights=" + flights +
                '}';
    }
}
