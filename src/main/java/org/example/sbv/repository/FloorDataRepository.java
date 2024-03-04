package org.example.sbv.repository;

import org.example.sbv.entity.FloorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorDataRepository extends JpaRepository<FloorData, Integer> {
    List<FloorData> findFloorDataByStructuralElementFrameId_CalculationId_Id(Integer idcalculation);
}
