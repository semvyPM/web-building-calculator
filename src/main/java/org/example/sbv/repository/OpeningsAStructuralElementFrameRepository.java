package org.example.sbv.repository;

import org.example.sbv.entity.OpeningsInAStructuralElementFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpeningsAStructuralElementFrameRepository extends JpaRepository<OpeningsInAStructuralElementFrame, Integer>{
}
