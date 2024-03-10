package org.example.sbv.repository;

import org.example.sbv.entity.PriceLists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListRepository extends JpaRepository<PriceLists, Integer> {
    PriceLists findPriceListsById(Integer id);
}
