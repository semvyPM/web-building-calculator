package org.example.sbv.repository;

import org.example.sbv.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Integer> {
    List<Calculation> findCalculationByCustomerId_IdAndCustomerId_UsersId_Id(Integer id, Integer userid);
    Calculation findCalculationByIdAndCustomerId_UsersId_Id(Integer id, Integer userid);
}
