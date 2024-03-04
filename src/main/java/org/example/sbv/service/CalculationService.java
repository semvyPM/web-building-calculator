package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Calculation;
import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.ResultsBasement;
import org.example.sbv.entity.ResultsFrame;
import org.example.sbv.repository.CalculationRepository;
import org.example.sbv.repository.FloorDataRepository;
import org.example.sbv.repository.ResultsBasementRepository;
import org.example.sbv.repository.ResultsFrameRepository;
import org.example.sbv.request.CalculationRequest;
import org.example.sbv.response.FloorResponse;
import org.example.sbv.response.ResultFrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;
    private final UsersService usersService;
    private final ResultsBasementRepository resultsBasementRepository;
    private final ResultsFrameRepository resultsFrameRepository;
    private final FloorDataRepository floorDataRepository;

    @Autowired
    public CalculationService(CalculationRepository calculationRepository, UsersService usersService, ResultsBasementRepository resultsBasementRepository, ResultsFrameRepository resultsFrameRepository, FloorDataRepository floorDataRepository) {
        this.calculationRepository = calculationRepository;
        this.usersService = usersService;
        this.resultsBasementRepository = resultsBasementRepository;
        this.resultsFrameRepository = resultsFrameRepository;
        this.floorDataRepository = floorDataRepository;
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
    public List<FloorResponse> getFloorData(HttpServletRequest request, Integer idcalculation) {
        if (usersService.getUserIdByJWT(request) != null) {
            List<FloorData> floorDataList = floorDataRepository.findFloorDataByStructuralElementFrameId_CalculationId_Id(idcalculation);
            FloorResponse floorResponse = new FloorResponse();
            List<FloorResponse> floorResponses = new ArrayList<>();
            for (FloorData floorData:floorDataList) {
                floorResponse.setId(floorDataList.get(0).getId());
                floorResponse.setFloorData(floorData);
                floorResponse.setResultFrameResponses(getResultsFrames(request, floorData.getId()));
                floorResponses.add(floorResponse);
            }
            return floorResponses;
        }
        else return null;
    }
    public List<ResultsBasement> getResultsBasements(HttpServletRequest request, Integer idcalculation) {
        if (usersService.getUserIdByJWT(request) != null) {
            return resultsBasementRepository.findResultsBasementsByStructuralElementBasement_CalculationId_Id(idcalculation);
        }
        else return null;
    }
    public List<ResultFrameResponse> getResultsFrames(HttpServletRequest request, Integer idfloor) {
        if (usersService.getUserIdByJWT(request) != null) {
            List<ResultFrameResponse> resultFrameResponses = new ArrayList<>();
            for (ResultsFrame resultFrame:resultsFrameRepository.findResultsFramesByFloorDataId_Id(idfloor)) {
                resultFrameResponses.add(new ResultFrameResponse(resultFrame.getId(), resultFrame.getAmount(), resultFrame.getPrice(), resultFrame.getFullPrice(), resultFrame.getMaterial_characteristics_id(), resultFrame.getResultTypeFloorFrame()));
            }
            return resultFrameResponses;
        }
        else return null;
    }
}
