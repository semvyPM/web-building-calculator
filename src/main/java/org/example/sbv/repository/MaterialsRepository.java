package org.example.sbv.repository;

import org.example.sbv.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsRepository extends JpaRepository<Materials, Integer> {
}
