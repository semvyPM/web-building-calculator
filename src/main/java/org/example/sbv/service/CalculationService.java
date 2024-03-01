package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Calculation;
import org.example.sbv.repository.CalculationRepository;
import org.example.sbv.request.CalculationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;
    private final UsersService usersService;
    @Autowired
    public CalculationService(CalculationRepository calculationRepository, UsersService usersService) {
        this.calculationRepository = calculationRepository;
        this.usersService = usersService;
    }
    public List<Calculation> getAllCalculation() {
        return calculationRepository.findAll();
    }
    public List<Calculation> getAllCalculationByUsers(HttpServletRequest request, Integer id) {
        return calculationRepository.findCalculationByCustomerId_IdAndCustomerId_UsersId_Id(id, usersService.getUserIdByJWT(request));
    }

    public Calculation getCalculationById(HttpServletRequest request, Integer id) {
        System.out.println("CHECK CALC BY ID " + calculationRepository.findCalculationByIdAndCustomerId_UsersId_Id(id, usersService.getUserIdByJWT(request)));
        return calculationRepository.findCalculationByIdAndCustomerId_UsersId_Id(id, usersService.getUserIdByJWT(request));
    }
    public Calculation addNewCalculation(CalculationRequest calculationRequest) {
        return calculationRepository.save(new Calculation(calculationRequest.getCustomerId(), calculationRequest.getAddressObjectConstractions(), calculationRequest.getNumber(), calculationRequest.getCreatedDate(), calculationRequest.getСalculationStateId()));
    }
}
