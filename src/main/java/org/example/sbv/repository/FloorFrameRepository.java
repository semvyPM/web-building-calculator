package org.example.sbv.repository;

import org.example.sbv.entity.FloorFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorFrameRepository extends JpaRepository<FloorFrame, Integer> {
}
