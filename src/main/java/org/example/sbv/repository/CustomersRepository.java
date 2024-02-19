package org.example.sbv.repository;

import org.example.sbv.entity.Customers;
import org.example.sbv.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
