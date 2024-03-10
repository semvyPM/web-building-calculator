package org.example.sbv.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.sbv.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, Integer> {
    Materials findMaterialsById(Integer id);

}
