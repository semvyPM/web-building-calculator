package org.example.sbv.repository;

import org.example.sbv.entity.Customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findCustomersByUsersId_Id(Integer id);
    Customers findCustomersByIdAndUsersId_Id(Integer id, Integer userid);

}
