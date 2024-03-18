package org.example.sbv.repository;

import org.example.sbv.entity.ResultsBasement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsBasementRepository extends JpaRepository<ResultsBasement, Integer> {
    List<ResultsBasement> findResultsBasementsByStructuralElementBasement_CalculationId_Id(Integer idcalcultation);
    List<ResultsBasement> findResultsBasementsByStructuralElementBasementId_Id(Integer id);
}
