package org.example.sbv.service;

import org.example.sbv.repository.*;
import org.example.sbv.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    private final ResultsBasementRepository resultsBasementRepository;
    private final StructuralElementFrameRepository structuralElementFrameRepository;
    private final StructuralElementBasementRepository structuralElementBasementRepository;
    private final FloorFrameRepository floorFrameRepository;

    @Autowired
    public ResultService(UsersRepository usersRepository, UsersUsersGroupRepository usersUsersGroupRepository, JwtService jwtService, ResultsBasementRepository resultsBasementRepository, StructuralElementFrameRepository structuralElementFrameRepository, StructuralElementBasementRepository structuralElementBasementRepository, FloorFrameRepository floorFrameRepository) {
        this.resultsBasementRepository = resultsBasementRepository;
        this.structuralElementFrameRepository = structuralElementFrameRepository;
        this.structuralElementBasementRepository = structuralElementBasementRepository;
        this.floorFrameRepository = floorFrameRepository;
    }

    public void getCalculationInfo(Integer idcalculation) {

    }
    public void getBasements(Integer idbasement) {

    }
    public void getFloors(Integer idcalculation) {
    }
}
