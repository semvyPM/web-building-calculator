package org.example.sbv.repository;

import org.example.sbv.entity.PriceLists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceListRepository extends JpaRepository<PriceLists, Integer> {
    List<PriceLists> findAllByOrderByDateDesc();
    PriceLists findPriceListsById(Integer id);
    List<PriceLists> findByMaterialCharacteristicsId_IdOrderByDateDesc(Integer materialId);
    List<PriceLists> findPriceListsByMaterialCharacteristicsId_IdOrderByDateDesc(Integer materialId);

}
