package org.example.sbv.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.*;
import org.example.sbv.request.CalculationRequest;
import org.example.sbv.request.FloorDataRequest;
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
    public List<Calculation> getAllCalculationsByCustomer(HttpServletRequest request, @PathVariable Integer id) {
        return calculationService.getAllCalculationByUsers(request, id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Calculation getCalculationById(HttpServletRequest request, @PathVariable Integer id) {
        return calculationService.getCalculationById(request, id);
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
    public Calculation addNewCalculation(HttpServletRequest request, @RequestBody Calculation calculation) {
        return calculationService.addNewCalculation(request, calculation);
    }
    @PostMapping("/frame/create")
    @ResponseBody
    public StructuralElementFrame addNewFrame(HttpServletRequest request, @RequestBody StructuralElementFrame structuralElementFrame) {
        return calculationService.addNewFrame(request, structuralElementFrame);
    }

    @PutMapping("/status")
    @ResponseBody
    public Calculation changeStatus(HttpServletRequest request, @RequestBody Calculation calculation) {
        return calculationService.changeStatus(request, calculation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCalculation(HttpServletRequest request, @PathVariable Integer id) {
        calculationService.deleteCalculation(request, id);
    }

    @GetMapping("/copy/{id}")
    public Calculation copyCalculationById(HttpServletRequest request, @PathVariable Integer id){
        return calculationService.copyCalculationById(request, id);
    }

    @PostMapping("/floordata/create")
    @ResponseBody
    public void floorDataPost(HttpServletRequest request, @RequestBody FloorDataRequest floorDataRequest) {
        calculationService.floorDataPost(request, floorDataRequest);
    }

}
