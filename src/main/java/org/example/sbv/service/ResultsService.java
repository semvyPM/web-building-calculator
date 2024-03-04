package org.example.sbv.service;

import org.example.sbv.entity.*;
import org.example.sbv.repository.*;
import org.example.sbv.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ResultsService {
    private final ResultsBasementRepository resultsBasementRepository;
    private final ResultsFrameRepository resultsFrameRepository;
    private final StructuralElementFrameRepository structuralElementFrameRepository;
    private final StructuralElementBasementRepository structuralElementBasementRepository;
    private final FloorDataRepository floorDataRepository;

    @Autowired
    public ResultsService(UsersRepository usersRepository, UsersUsersGroupRepository usersUsersGroupRepository, JwtService jwtService, ResultsBasementRepository resultsBasementRepository, ResultsFrameRepository resultsFrameRepository, StructuralElementFrameRepository structuralElementFrameRepository, StructuralElementBasementRepository structuralElementBasementRepository, FloorDataRepository floorDataRepository) {
        this.resultsBasementRepository = resultsBasementRepository;
        this.resultsFrameRepository = resultsFrameRepository;
        this.structuralElementFrameRepository = structuralElementFrameRepository;
        this.structuralElementBasementRepository = structuralElementBasementRepository;
        this.floorDataRepository = floorDataRepository;
    }


}
