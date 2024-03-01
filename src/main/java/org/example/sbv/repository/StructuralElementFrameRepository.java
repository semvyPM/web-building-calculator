package org.example.sbv.repository;

import org.example.sbv.entity.StructuralElementFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructuralElementFrameRepository extends JpaRepository<StructuralElementFrame, Integer> {
}
