package org.example.sbv.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Calculation;
import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.ResultsBasement;
import org.example.sbv.entity.ResultsFrame;
import org.example.sbv.request.CalculationRequest;
import org.example.sbv.response.FloorResponse;
import org.example.sbv.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculations")
public class CalculationController {
    private final CalculationService calculationService;
    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/by-customer/{id}")
    @ResponseBody
    public List<Calculation> getAllCustomersByCustomer(HttpServletRequest request, @PathVariable Integer id) {
        List<Calculation> calculations = calculationService.getAllCalculationByUsers(request, id);
        System.out.println("CALCULAT " + calculations);
        return calculations;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Calculation getCustomerById(HttpServletRequest request, @PathVariable Integer id) {
        Calculation calculation = calculationService.getCalculationById(request, id);
        return calculation;
    }

    @GetMapping("/floors/{idcalculation}")
    @ResponseBody
    public List<FloorResponse> getFloorDataByCalculation(HttpServletRequest request, @PathVariable Integer idcalculation) {
        return calculationService.getFloorData(request, idcalculation);
    }

    @GetMapping("/basements/{idcalculation}")
    @ResponseBody
    public List<ResultsBasement> getBasementsDataByCalculation(HttpServletRequest request, @PathVariable Integer idcalculation) {
        return calculationService.getResultsBasements(request, idcalculation);
    }

    @PostMapping("/create")
    @ResponseBody
    public Calculation addNewCalculation(@RequestBody CalculationRequest calculationRequest) {
        return calculationService.addNewCalculation(calculationRequest);
    }
}
