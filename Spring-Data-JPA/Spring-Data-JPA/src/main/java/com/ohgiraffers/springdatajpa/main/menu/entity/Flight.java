package com.ohgiraffers.springdatajpa.main.menu.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "info_flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_no")
    private int flightNo;      // 비행코드
    @Column(name = "flight_code")
    private String flightCode;        // 비행번호 (예시 : KE 018)
    @Column(name = "flight_date")
    private LocalDate flightDate;   // 비행 날짜
    @Column(name = "destination")
    private String destination;     // 목적지
    @Column(name = "ticket_price")
    private double ticketPrice;        // 티켓 가격
    @Column(name = "depart_time")
    private LocalTime departTime;   // 이륙 시간
    @Column(name = "arrival_time")
    private LocalTime arrivalTime;  // 착륙 시간

    @ManyToOne
    @JoinColumn(name = "airline_no")
    private Airline airline;        // 항공사 (FK)

    protected Flight() {}

    public Flight(int flightNo, String flightCode, LocalDate flightDate, String destination, double ticketPrice, LocalTime departTime, LocalTime arrivalTime) {
        this.flightNo = flightNo;
        this.flightCode = flightCode;
        this.flightDate = flightDate;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight(int flightNo, String flightCode, LocalDate flightDate, String destination, double ticketPrice, LocalTime departTime, LocalTime arrivalTime, Airline airline) {
        this.flightNo = flightNo;
        this.flightCode = flightCode;
        this.flightDate = flightDate;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.airline = airline;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public LocalTime getDepartTime() {
        return departTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public Airline getAirline() {
        return airline;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightCode=" + flightCode +
                ", flightNo='" + flightNo + '\'' +
                ", flightDate=" + flightDate +
                ", destination='" + destination + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", departTime=" + departTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
