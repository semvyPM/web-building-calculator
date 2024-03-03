package org.example.sbv.repository;

import org.example.sbv.entity.ResultsFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsFrameRepository extends JpaRepository<ResultsFrame, Integer> {

}
