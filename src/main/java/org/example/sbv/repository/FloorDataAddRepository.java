package org.example.sbv.repository;

import org.example.sbv.entity.FloorData;
import org.example.sbv.entity.FloorDataAdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorDataAddRepository extends JpaRepository<FloorDataAdd, Integer> {
    List<FloorDataAdd> findFloorDataAddsByFloorDataId_Id(Integer idfloor);
}
