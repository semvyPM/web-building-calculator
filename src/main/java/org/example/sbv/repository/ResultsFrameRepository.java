package org.example.sbv.repository;

import org.example.sbv.entity.ResultsFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsFrameRepository extends JpaRepository<ResultsFrame, Integer> {
    List<ResultsFrame> findResultsFramesByFloorDataId_Id(Integer idcalculation);
}
