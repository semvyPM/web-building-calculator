package org.example.sbv.repository;

import org.example.sbv.entity.FloorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorFrameRepository extends JpaRepository<FloorData, Integer> {
}
