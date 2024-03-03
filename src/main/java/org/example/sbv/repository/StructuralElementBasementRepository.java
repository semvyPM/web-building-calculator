package org.example.sbv.repository;

import org.example.sbv.entity.StructuralElementBasement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructuralElementBasementRepository extends JpaRepository<StructuralElementBasement, Integer> {
    StructuralElementBasement findStructuralElementBasementById(Integer idbasement);
}
