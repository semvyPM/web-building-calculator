package org.example.sbv.repository;

import org.example.sbv.entity.CalculationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationStateRepository extends JpaRepository<CalculationState, Integer> {
}
