package org.example.sbv.repository;

import org.example.sbv.entity.UsersUsersGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersUsersGroupRepository extends JpaRepository<UsersUsersGroup, Integer> {
    List<UsersUsersGroup> findUsersUsersGroupByUsersId_Id(Integer id);
}
