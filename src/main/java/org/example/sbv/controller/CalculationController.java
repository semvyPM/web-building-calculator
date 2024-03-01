package org.example.sbv.controller;

import org.example.sbv.entity.Calculation;
import org.example.sbv.entity.Customers;
import org.example.sbv.response.CalculationRequest;
import org.example.sbv.response.CustomersRequest;
import org.example.sbv.service.CalculationService;
import org.example.sbv.service.CustomersService;
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
    public ResponseEntity<List<Calculation>> getAllCustomersByCustomer(@PathVariable Integer id) {
        List<Calculation> calculations = calculationService.getAllCalculationByUsers(id);
        if (calculations != null) {
            return ResponseEntity.ok(calculations);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Calculation> getCustomerById(@PathVariable Integer id) {
        Calculation calculation = calculationService.getCalculationById(id);
        if (calculation != null) {
            return ResponseEntity.ok(calculation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Calculation> addNewCalculation(@RequestBody CalculationRequest calculationRequest) {
        Calculation calculation = calculationService.addNewCalculation(calculationRequest);
        if (calculation != null) {
            return ResponseEntity.ok(calculation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
