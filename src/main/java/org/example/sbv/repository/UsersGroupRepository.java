package org.example.sbv.repository;

import org.example.sbv.entity.UsersGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersGroupRepository extends JpaRepository<UsersGroup, Integer> {

}
