package org.example.sbv.repository;

import org.example.sbv.entity.MeasurementUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementUnitsRepository extends JpaRepository<MeasurementUnits, Integer> {
}
