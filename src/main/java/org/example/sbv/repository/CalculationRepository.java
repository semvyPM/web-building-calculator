package org.example.sbv.repository;

import org.example.sbv.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<Calculation, Integer> {

}
