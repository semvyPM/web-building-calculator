package org.example.sbv.repository;

import org.example.sbv.entity.ResultsBasement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsBasementRepository extends JpaRepository<ResultsBasement, Integer> {

}
