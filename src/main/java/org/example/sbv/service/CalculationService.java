package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.*;
import org.example.sbv.repository.*;
import org.example.sbv.request.FloorDataAddRequest;
import org.example.sbv.request.FloorDataRequest;
import org.example.sbv.request.OpeningsRequest;
import org.example.sbv.request.ResultFrameRequest;
import org.example.sbv.response.FloorAddResponse;
import org.example.sbv.response.FloorResponse;
import org.example.sbv.response.ResultFrameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;
    private final CustomersRepository customersRepository;
    private final UsersService usersService;
    private final ResultsBasementRepository resultsBasementRepository;
    private final ResultsFrameRepository resultsFrameRepository;
    private final FloorDataRepository floorDataRepository;
    private final FloorDataAddRepository floorDataAddRepository;
    private final StructuralElementBasementRepository structuralElementBasementRepository;
    private final StructuralElementFrameRepository structuralElementFrameRepository;
    private final OpeningsRepository openingsRepository;

    @Autowired
    public CalculationService(CalculationRepository calculationRepository, CustomersRepository customersRepository, UsersService usersService, ResultsBasementRepository resultsBasementRepository, ResultsFrameRepository resultsFrameRepository, FloorDataRepository floorDataRepository, FloorDataAddRepository floorDataAddRepository, StructuralElementBasementRepository structuralElementBasementRepository, StructuralElementFrameRepository structuralElementFrameRepository, OpeningsRepository openingsRepository) {
        this.calculationRepository = calculationRepository;
        this.customersRepository = customersRepository;
        this.usersService = usersService;
        this.resultsBasementRepository = resultsBasementRepository;
        this.resultsFrameRepository = resultsFrameRepository;
        this.floorDataRepository = floorDataRepository;
        this.floorDataAddRepository = floorDataAddRepository;
        this.structuralElementBasementRepository = structuralElementBasementRepository;
        this.structuralElementFrameRepository = structuralElementFrameRepository;
        this.openingsRepository = openingsRepository;
    }
    public List<Calculation> getAllCalculation() {
        return calculationRepository.findAll();
    }
    public List<Calculation> getAllCalculationByUsers(HttpServletRequest request, Integer id) {
        return calculationRepository.findCalculationByCustomerId_IdAndCustomerId_UsersId_IdOrderByNumberDesc(id, usersService.getUserIdByJWT(request));
    }

    public Calculation getCalculationById(HttpServletRequest request, Integer id) {
        return calculationRepository.findCalculationByIdAndCustomerId_UsersId_Id(id, usersService.getUserIdByJWT(request));
    }
    public Calculation addNewCalculation(HttpServletRequest request, Calculation calculation) {
        if (usersService.getUserIdByJWT(request) != null) {
            return calculationRepository.save(new Calculation(customersRepository.findById(calculation.getCustomerId().getId()).get(), calculation.getAddressObjectConstractions(), calculation.getNumber(), calculation.getCreatedDate(), calculation.getCalculationStateId()));
        }
        else {
            return null;
        }
    }

    public StructuralElementFrame addNewFrame(HttpServletRequest request, StructuralElementFrame structuralElementFrame) {
        if (usersService.getUserIdByJWT(request) != null) {
            System.out.println(structuralElementFrame.toString());
            return structuralElementFrameRepository.save(new StructuralElementFrame(structuralElementFrame.getAmountFloor(), structuralElementFrame.getCalculationId()));
        }
        else {
            return null;
        }
    }

    public Calculation changeStatus(HttpServletRequest request, Calculation calculation) {
        if (usersService.getUserIdByJWT(request) != null) {
            return calculationRepository.save(calculation);
        }
        else {
            System.out.println("nULLL");
            return null;
        }
    }

    public void deleteCalculation(HttpServletRequest request, Integer id) {
        if (usersService.getUserIdByJWT(request) != null) {
            calculationRepository.deleteById(id);
        }
    }

    public Calculation copyCalculationById(HttpServletRequest request, Integer id){
        Integer user = usersService.getUserIdByJWT(request);
        if (user != null) {
            Calculation calculation = calculationRepository.findById(id).get();
            Calculation newCalculation = new Calculation();
            newCalculation.setCustomerId(calculation.getCustomerId());
            newCalculation.setAddressObjectConstractions(calculation.getAddressObjectConstractions());
            newCalculation.setNumber(getLastNumber(calculation.getCustomerId().getId()).getNumber() + 1);
            newCalculation.setCreatedDate(calculation.getCreatedDate());
            newCalculation.setCalculationStateId(calculation.getCalculationStateId());

            newCalculation = calculationRepository.save(newCalculation);

            StructuralElementBasement sEB = structuralElementBasementRepository.findStructuralElementBasementByCalculationId_Id(id);
            if (sEB != null) {
                StructuralElementBasement structuralElementBasementNew = structuralElementBasementRepository.save(new StructuralElementBasement(sEB.getPerimeterOfExternalWalls(), sEB.getInternalWallLength(), sEB.getConcretePiles(), sEB.getConcrete(), newCalculation));
                List<ResultsBasement> resultsBasementList = resultsBasementRepository.findResultsBasementsByStructuralElementBasementId_Id(sEB.getId());
                for (ResultsBasement resultBasement:resultsBasementList) {
                    resultsBasementRepository.save(new ResultsBasement(resultBasement.getMaterial_characteristics_id(), resultBasement.getAmount(), resultBasement.getPrice(), resultBasement.getFullPrice(), structuralElementBasementNew));
                }
            }

            StructuralElementFrame sEF = structuralElementFrameRepository.findStructuralElementFrameByCalculationId_Id(id);
            if (sEF != null) {
                StructuralElementFrame structuralElementFrameNew = structuralElementFrameRepository.save(new StructuralElementFrame(sEF.getAmountFloor(), newCalculation));
                List<FloorData> floorDataList = floorDataRepository.findFloorDataByStructuralElementFrameId_Id(sEF.getId());
                for (FloorData floorData:floorDataList) {
                    FloorData floorDataNew = floorDataRepository.save(new FloorData(floorData.getFloorNumber(), floorData.getFloorHeight(), floorData.getPerimeterOfExternalWalls(),floorData.getBaseArea(), floorData.getExternalWallThickness(), floorData.getInternalWallLength(), floorData.getInternalWallThickness(), floorData.getSlabThickness(), structuralElementFrameNew));
                    List<FloorDataAdd> floorDataAddList = floorDataAddRepository.findFloorDataAddsByFloorDataId_Id(floorDataNew.getId());
                    for (FloorDataAdd floorDataAdd:floorDataAddList) {
                        floorDataAddRepository.save(new FloorDataAdd(floorDataAdd.getTypeAdd(), floorDataNew, floorDataAdd.getMaterialCharacteristicsId()));
                    }
                    List<ResultsFrame> resultsFrameList = resultsFrameRepository.findResultsFramesByFloorDataId_Id(floorData.getId());
                    for (ResultsFrame resultsFrame:resultsFrameList) {
                        resultsFrameRepository.save(new ResultsFrame(resultsFrame.getMaterial_characteristics_id(), resultsFrame.getAmount(), resultsFrame.getPrice(), resultsFrame.getFullPrice(), floorDataNew, resultsFrame.getResultTypeFloorFrame()));
                    }
                    List<Openings> openingsList = openingsRepository.findOpeningsByFloorData_Id(floorData.getId());
                    for (Openings opS:openingsList) {
                        openingsRepository.save(new Openings(opS.getType(), opS.getHeight(), opS.getWidth(), opS.getAmount(), floorDataNew));
                    }
                }


            }
            return newCalculation;
        }
        else return null;
    }

    public void floorDataPost(HttpServletRequest request, FloorDataRequest floorDataRequest) {
        if (usersService.getUserIdByJWT(request) != null) {
            FloorData floorData = floorDataRepository.save(floorDataRequest.getFloorData());
            for (OpeningsRequest opening:floorDataRequest.getOpeningsList()) {
                openingsRepository.save(new Openings(opening.getType(), opening.getHeight(), opening.getWidth(), opening.getAmount(), floorData));
            }
            for (FloorDataAddRequest floorDataAddRequest:floorDataRequest.getFloorDataAdds()) {
                floorDataAddRepository.save(new FloorDataAdd(floorDataAddRequest.getTypeAdd(), floorData, floorDataAddRequest.getMaterialCharacteristics()));
            }
            for (ResultFrameRequest resultFrameRequest:floorDataRequest.getResultsFrames()) {
                resultsFrameRepository.save(new ResultsFrame(resultFrameRequest.getMaterialCharacteristics(), resultFrameRequest.getAmount(), resultFrameRequest.getPrice(), resultFrameRequest.getFullPrice(), floorData, resultFrameRequest.getResultTypeFloorFrame()));
            }

        }
    }
    private Calculation getLastNumber(Integer id) {
        List<Calculation> lastId = calculationRepository.findCalculationsByCustomerId_IdOrderByNumberDesc(id);
        if (!lastId.isEmpty()) {
            return lastId.get(0);
        }
        else return null;
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
            return resultFrameResponses;
        }
        else return null;
    }
}
