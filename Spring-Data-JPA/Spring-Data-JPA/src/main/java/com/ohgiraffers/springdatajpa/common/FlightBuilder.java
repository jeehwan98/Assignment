package com.ohgiraffers.springdatajpa.common;

import com.ohgiraffers.springdatajpa.main.menu.entity.Airline;
import com.ohgiraffers.springdatajpa.main.menu.entity.Flight;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightBuilder {

    private int flightNo;        // 비행 번호
    private String flightCode;      // 비행코드
    private String destination;     // 목적지
    private LocalDate flightDate;   // 비행 날짜
    private double ticketPrice;     // 티켓 가격
    private LocalTime departTime;   // 이륙 시간
    private LocalTime arrivalTime;  // 착륙 시간
//    private Airline airline;

    public FlightBuilder(int flightNo, String flightCode) {
        this.flightNo = flightNo;
        this.flightCode = flightCode;
    }

    public FlightBuilder(int flightNo, String flightCode, String destination, LocalDate flightDate, double ticketPrice, LocalTime departTime, LocalTime arrivalTime, Airline airline) {
        this.flightNo = flightNo;
        this.flightCode = flightCode;
        this.destination = destination;
        this.flightDate = flightDate;
        this.ticketPrice = ticketPrice;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
//        this.airline = airline;
    }

    public FlightBuilder(Flight flight) {
    }

    public FlightBuilder flightNo (int val) {
        this.flightNo = val;
        return this;
    }

    public FlightBuilder flightCode (String val) {
        this.flightCode = val;
        return this;
    }

    public FlightBuilder destination (String val) {
        this.destination = val;
        return this;
    }

    public FlightBuilder flightDate (LocalDate val) {
        this.flightDate = val;
        return this;
    }

    public FlightBuilder ticketPrice (double val) {
        this.ticketPrice = val;
        return this;
    }

    public FlightBuilder departTime (LocalTime val) {
        this.departTime = val;
        return this;
    }

    public FlightBuilder arrivalTime (LocalTime val) {
        this.arrivalTime = val;
        return this;
    }

//    public FlightBuilder airline (Airline val) {
//        this.airline = val;
//        return this;
//    }

    public Flight builder() {/*, airline*/
        return new Flight(flightNo, flightCode, flightDate, destination, ticketPrice, departTime, arrivalTime);
    }

}
