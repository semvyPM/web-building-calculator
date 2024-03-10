package org.example.sbv.repository;

import org.example.sbv.entity.MaterialCharacteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialCharacteristicsRepository extends JpaRepository<MaterialCharacteristics, Integer> {
    MaterialCharacteristics findMaterialCharacteristicsById(Integer id);
}
