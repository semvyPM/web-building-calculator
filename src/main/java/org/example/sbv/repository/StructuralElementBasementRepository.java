package org.example.sbv.repository;

import org.example.sbv.entity.StructuralElementBasement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StructuralElementBasementRepository extends JpaRepository<StructuralElementBasement, Integer> {
    StructuralElementBasement findStructuralElementBasementByCalculationId_Id(Integer id);

}
