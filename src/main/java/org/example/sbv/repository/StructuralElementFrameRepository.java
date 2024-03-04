package org.example.sbv.repository;

import org.example.sbv.entity.StructuralElementFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StructuralElementFrameRepository extends JpaRepository<StructuralElementFrame, Integer> {
    StructuralElementFrame findStructuralElementFrameByCalculationId_Id(Integer idcalculation);
}
