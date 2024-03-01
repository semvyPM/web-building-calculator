package org.example.sbv.service;

import org.example.sbv.entity.Calculation;
import org.example.sbv.entity.Customers;
import org.example.sbv.repository.CalculationRepository;
import org.example.sbv.repository.CustomersRepository;
import org.example.sbv.response.CalculationRequest;
import org.example.sbv.response.CustomersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;
    @Autowired
    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }
    public List<Calculation> getAllCalculation() {
        return calculationRepository.findAll();
    }
    public List<Calculation> getAllCalculationByUsers(Integer id) {
        return calculationRepository.findCalculationByCustomerId_Id(id);
    }

    public Calculation getCalculationById(Integer id) {
        return calculationRepository.findCalculationById(id);
    }
    public Calculation addNewCalculation(CalculationRequest calculationRequest) {
        return calculationRepository.save(new Calculation(calculationRequest.getCustomerId(), calculationRequest.getAddressObjectConstractions(), calculationRequest.getNumber(), calculationRequest.getCreatedDate(), calculationRequest.getСalculationStateId()));
    }
}
