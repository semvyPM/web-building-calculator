package org.example.sbv.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Calculation;
import org.example.sbv.request.CalculationRequest;
import org.example.sbv.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Calculation>> getAllCustomers() {
        List<Calculation> calculations = calculationService.getAllCalculation();
        if (calculations != null) {
            return ResponseEntity.ok(calculations);
        } else {
            return ResponseEntity.notFound().build();
        }
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

    @PostMapping("/create")
    @ResponseBody
    public Calculation addNewCalculation(@RequestBody CalculationRequest calculationRequest) {
        Calculation calculation = calculationService.addNewCalculation(calculationRequest);
        return calculation;
    }
}
