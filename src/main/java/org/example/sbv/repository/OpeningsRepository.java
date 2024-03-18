package org.example.sbv.repository;

import org.example.sbv.entity.Openings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpeningsRepository extends JpaRepository<Openings, Integer> {
    List<Openings> findOpeningsByFloorData_Id(Integer id);
}
