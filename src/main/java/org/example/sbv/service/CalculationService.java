package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.*;
import org.example.sbv.repository.*;
import org.example.sbv.request.CalculationRequest;
import org.example.sbv.response.FloorAddResponse;
import org.example.sbv.response.FloorResponse;
import org.example.sbv.response.ResultFrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private final FloorDataAddRepository floorDataAddRepository;
    private final StructuralElementBasementRepository structuralElementBasementRepository;
    private final StructuralElementFrameRepository structuralElementFrameRepository;


    @Autowired
    public CalculationService(CalculationRepository calculationRepository, UsersService usersService, ResultsBasementRepository resultsBasementRepository, ResultsFrameRepository resultsFrameRepository, FloorDataRepository floorDataRepository, FloorDataAddRepository floorDataAddRepository, StructuralElementBasementRepository structuralElementBasementRepository, StructuralElementFrameRepository structuralElementFrameRepository) {
        this.calculationRepository = calculationRepository;
        this.usersService = usersService;
        this.resultsBasementRepository = resultsBasementRepository;
        this.resultsFrameRepository = resultsFrameRepository;
        this.floorDataRepository = floorDataRepository;
        this.floorDataAddRepository = floorDataAddRepository;
        this.structuralElementBasementRepository = structuralElementBasementRepository;
        this.structuralElementFrameRepository = structuralElementFrameRepository;
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
    public Calculation addNewCalculation(HttpServletRequest request, CalculationRequest calculationRequest) {
        if (usersService.getUserIdByJWT(request) != null) {
            return calculationRepository.save(new Calculation(calculationRequest.getCustomerId(), calculationRequest.getAddressObjectConstractions(), calculationRequest.getNumber(), calculationRequest.getCreatedDate(), calculationRequest.getCalculationStateId()));
        }
        else {
            return null;
        }
    }
    public Calculation deleteCalculation(HttpServletRequest request, Integer id){
        if (usersService.getUserIdByJWT(request) != null) {
            calculationRepository.deleteById(id);
        }
        else{
            return null;
        }
        return null;
    }
    public List<FloorResponse> getFloorData(HttpServletRequest request, Integer idcalculation) {
        if (usersService.getUserIdByJWT(request) != null) {
            List<FloorData> floorDataList = floorDataRepository.findFloorDataByStructuralElementFrameId_CalculationId_Id(idcalculation);
//            FloorResponse floorResponse = new FloorResponse();
            List<FloorResponse> floorResponses = new ArrayList<>();
            Float resultForInnerWallsSum;
            Float resultForOuterWallsSum;
            Float resultForOverlapsSum;
            List<ResultFrameResponse> resultForInnerWalls = new ArrayList<>();
            List<ResultFrameResponse> resultForOuterWalls = new ArrayList<>();
            List<ResultFrameResponse> resultForOverlaps = new ArrayList<>();
            List<FloorAddResponse> floorDataAdds = new ArrayList<>();
            for (FloorData floorData:floorDataList) {
                FloorResponse floorResponse = new FloorResponse();
                floorResponse.setId(floorData.getId());
                System.out.println(floorData.getId());
                floorResponse.setFloorData(floorData);
                for (FloorDataAdd floorDataAdd:floorDataAddRepository.findFloorDataAddsByFloorDataId_Id(floorData.getId())) {
                    floorDataAdds.add(new FloorAddResponse(floorDataAdd.getId(), floorDataAdd.getTypeAdd(), floorDataAdd.getMaterialCharacteristicsId()));
                }
                floorResponse.setFloorDataAdd(floorDataAdds);
                resultForInnerWalls= new ArrayList<>();
                resultForOuterWalls= new ArrayList<>();
                resultForOverlaps= new ArrayList<>();
                resultForInnerWallsSum = (float) 0;
                resultForOuterWallsSum = (float) 0;
                resultForOverlapsSum = (float) 0;
                List<ResultFrameResponse> resultFrameResponses = getResultsFrames(request, floorData.getId());

                for (ResultFrameResponse resultFrameResponse:resultFrameResponses) {
                    switch (resultFrameResponse.getResultTypeFloorFrame().getId()) {
                        case (1):
                            resultForInnerWalls.add(resultFrameResponse);
                            resultForInnerWallsSum += resultFrameResponse.getFullPrice();
                            break;
                        case (2):
                            resultForOuterWalls.add(resultFrameResponse);
                            resultForOuterWallsSum += resultFrameResponse.getFullPrice();
                            break;
                        case (3):
                            resultForOverlaps.add(resultFrameResponse);
                            resultForOverlapsSum += resultFrameResponse.getFullPrice();
                            break;
                    }
                }
                floorResponse.setResultForInnerWalls(resultForInnerWalls);
                floorResponse.setResultForInnerWallsSum(resultForInnerWallsSum);
                floorResponse.setResultForOuterWalls(resultForOuterWalls);
                floorResponse.setResultForOuterWallsSum(resultForOuterWallsSum);
                floorResponse.setResultForOverlaps(resultForOverlaps);
                floorResponse.setResultForOverlapsSum(resultForOverlapsSum);
                floorResponse.setResultSum(resultForInnerWallsSum + resultForOuterWallsSum + resultForOverlapsSum);
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
            System.out.println(resultFrameResponses.toString());
            return resultFrameResponses;
        }
        else return null;
    }

}
