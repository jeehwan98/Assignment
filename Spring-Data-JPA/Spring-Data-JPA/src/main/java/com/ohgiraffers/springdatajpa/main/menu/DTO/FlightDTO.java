package com.ohgiraffers.springdatajpa.main.menu.DTO;

import com.ohgiraffers.springdatajpa.main.menu.entity.Airline;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDTO {


    private int flightNo;           // 비행 번호
    private String flightCode;      // 비행코드
    private String destination;     // 목적지
    private LocalDate flightDate;   // 비행 날짜
    private double ticketPrice;     // 티켓 가격
    private LocalTime departTime;   // 이륙 시간
    private LocalTime arrivalTime;  // 착륙 시간
    private AirlineDTO airlineDTO;

    public FlightDTO() {}

    public FlightDTO(String flightCode, String destination, LocalDate flightDate, double ticketPrice, LocalTime departTime, LocalTime arrivalTime, int flightNo, AirlineDTO airlineDTO) {
        this.flightCode = flightCode;
        this.destination = destination;
        this.flightDate = flightDate;
        this.ticketPrice = ticketPrice;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.flightNo = flightNo;
        this.airlineDTO = airlineDTO;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public LocalTime getDepartTime() {
        return departTime;
    }

    public void setDepartTime(LocalTime departTime) {
        this.departTime = departTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public AirlineDTO getAirlineDTO() {
        return airlineDTO;
    }

    public void setAirlineDTO(AirlineDTO airlineDTO) {
        this.airlineDTO = airlineDTO;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "flightNo=" + flightNo +
                ", flightCode='" + flightCode + '\'' +
                ", destination='" + destination + '\'' +
                ", flightDate=" + flightDate +
                ", ticketPrice=" + ticketPrice +
                ", departTime=" + departTime +
                ", arrivalTime=" + arrivalTime +
                ", airlineDTO=" + airlineDTO +
                '}';
    }
}
