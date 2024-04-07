package com.ohgiraffers.springdatajpa.main.menu.controller;

import com.ohgiraffers.springdatajpa.common.Pagenation;
import com.ohgiraffers.springdatajpa.common.PagingButton;
import com.ohgiraffers.springdatajpa.main.menu.DTO.AirlineDTO;
import com.ohgiraffers.springdatajpa.main.menu.DTO.FlightDTO;
import com.ohgiraffers.springdatajpa.main.menu.entity.Flight;
import com.ohgiraffers.springdatajpa.main.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/airline")
    public String findAllAirlinesRegistered(Model model) {  // 등록이 되어있는 항공사 확인용
        List<AirlineDTO> airlineList = menuService.findAllAirlinesRegistered();
        System.out.println(airlineList);
        model.addAttribute("airlineList",airlineList);
        return "menu/airline";
    }

    @GetMapping("/regist/{airline_no}")
    public String showRegistrationForm(@PathVariable("airline_no") int airlineNo, Model model) {
        System.out.println("비행코드 : " + airlineNo + "(1번 : 대한항공, 2번 : 아시아나 항공)");
        model.addAttribute("airlineNo",airlineNo);
        return "menu/regist";
    }

    @PostMapping("/regist/{airline_no}")
    public String registFlightDetails(@ModelAttribute FlightDTO flightDTO, @PathVariable("airline_no") int airlineNo) {
        System.out.println("도착");
        menuService.registFlightNo(flightDTO,airlineNo);
        System.out.println(flightDTO);  // 저장이 잘 됐는지 확인용

        return "redirect:/main"; // 등록이 다 됐으면 메인페이지로 돌아가기
    }

    @GetMapping("/list")
    public String getFlightList(@PageableDefault Pageable pageable, Model model) {
        System.out.println("flight list");
        Page<FlightDTO> flightList = menuService.findAllFlights(pageable);

        PagingButton paging = Pagenation.getPagingButtonInfo(flightList);
        model.addAttribute("paging",paging);
        model.addAttribute("flightList",flightList);

        return "menu/list";
    }
    @GetMapping("/update")
    public void updateFlightDetails() {}

    @PostMapping("/update")
    public String updateFlightDetails(@ModelAttribute FlightDTO updateFlight) {
        System.out.println(updateFlight.getFlightNo());     // 비행번호 (1)
        System.out.println(updateFlight.getDestination());  // 목적지  (브라질)
        menuService.updateFlight(updateFlight);
        return "redirect:/main";
    }

    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteFlight(@RequestParam int flightNo) {
        menuService.deleteFlight(flightNo);
        return "redirect:/menu/list";
    }

}
