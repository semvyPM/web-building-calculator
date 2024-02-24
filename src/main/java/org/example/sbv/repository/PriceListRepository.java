package org.example.sbv.repository;

import org.example.sbv.entity.PriceLists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceListRepository extends JpaRepository<PriceLists, Integer> {
}
