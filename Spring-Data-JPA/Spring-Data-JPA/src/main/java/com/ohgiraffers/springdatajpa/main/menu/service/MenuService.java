package com.ohgiraffers.springdatajpa.main.menu.service;

import com.ohgiraffers.springdatajpa.common.FlightBuilder;
import com.ohgiraffers.springdatajpa.main.menu.DTO.AirlineDTO;
import com.ohgiraffers.springdatajpa.main.menu.DTO.FlightDTO;
import com.ohgiraffers.springdatajpa.main.menu.entity.Airline;
import com.ohgiraffers.springdatajpa.main.menu.entity.Flight;
import com.ohgiraffers.springdatajpa.main.repository.AirlineRepository;
import com.ohgiraffers.springdatajpa.main.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final ModelMapper modelMapper;
    private final AirlineRepository airlineRepository;
    private final FlightRepository flightRepository;

    public MenuService(ModelMapper modelMapper, AirlineRepository airlineRepository, FlightRepository flightRepository) {
        this.modelMapper = modelMapper;
        this.airlineRepository = airlineRepository;
        this.flightRepository = flightRepository;
    }

    public List<AirlineDTO> findAllAirlinesRegistered() {
        List<Airline> airlineList = airlineRepository.findAll();

        List<AirlineDTO> airlineDTOList = new ArrayList<>();
        for(Airline airline : airlineList) {
            AirlineDTO airlineDTO = modelMapper.map(airline, AirlineDTO.class);
            airlineDTOList.add(airlineDTO);
        }

        return airlineDTOList;
    }

    @Transactional
    public void registFlightNo(FlightDTO flightDTO, int airlineNo) {
        AirlineDTO airlineDTO = new AirlineDTO();
        airlineDTO.setAirlineNo(airlineNo);
        flightDTO.setAirlineDTO(airlineDTO);    // 저장한 airlineNo을 flightDTO안에다가도 저장..!
        System.out.println(flightDTO);
        System.out.println(airlineNo);
        flightRepository.save(modelMapper.map(flightDTO, Flight.class));
    }

    public Page<FlightDTO> findAllFlights(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize(), Sort.by("flightNo").descending());

        Page<Flight> flightList = flightRepository.findAll(pageable);
        return flightList.map(flight -> modelMapper.map(flight, FlightDTO.class));
    }

    @Transactional
    public void updateFlight(FlightDTO updateFlight) {
        System.out.println("⚡️⚡️⚡️⚡️⚡️⚡️" + updateFlight);   // 잘 받았는지 확인
//        int flightNo = updateFlight.getFlightNo();
//        System.out.println("😀😀😀😀" + flightNo);  // 비행번호
//        String getDestination = updateFlight.getDestination();
//        System.out.println("😀😀😀😀" + getDestination);
//        Flight flight = new Flight(flightNo,getDestination);

        System.out.println(updateFlight.getFlightNo() + "🩷");
        Flight flightToUpdate = flightRepository.findById(updateFlight.getFlightNo()).orElseThrow(IllegalArgumentException::new);
        System.out.println("🩷");
        flightToUpdate.setDestination(updateFlight.getDestination());
        flightRepository.save(flightToUpdate);
//        flightToUpdate = new FlightBuilder(flightToUpdate).destination(updateFlight.getDestination()).builder();
//        flightToUpdate = new FlightBuilder(flightToUpdate).destination(updateFlight.getDestination()).builder();
//        flightRepository.save(flightToUpdate); // stackOverFlow error
        System.out.println(flightToUpdate);
    }

    @Transactional
    public void deleteFlight(int flightNo) {
        flightRepository.deleteById(flightNo);
    }
}
