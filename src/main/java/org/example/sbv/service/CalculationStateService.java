package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.CalculationState;
import org.example.sbv.entity.MaterialCharacteristics;
import org.example.sbv.repository.CalculationStateRepository;
import org.example.sbv.repository.MaterialCharacteristicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationStateService {
    public final CalculationStateRepository calculationStateRepository;

    private final UsersService usersService;
    @Autowired
    public CalculationStateService(UsersService usersService, CalculationStateRepository calculationStateRepository){
        this.calculationStateRepository = calculationStateRepository;
        this.usersService = usersService;
    }
    public CalculationState getCalculationState(HttpServletRequest request, Integer id){
        if (usersService.getUserIdByJWT(request) != null){
            return calculationStateRepository.findById(id).get();
        }
        else return null;
    }
}
