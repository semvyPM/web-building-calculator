package org.example.sbv.service;

import org.example.sbv.entity.Customers;
import org.example.sbv.repository.CustomersRepository;
import org.example.sbv.response.CustomersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;
    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }
    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }
    public List<Customers> getAllCustomersByUsers(Integer id) {
        return customersRepository.findCustomersByUsersId_Id(id);
    }

    public Customers getCustomerById(Integer id) {
        return customersRepository.findCustomersById(id);
    }
    public Customers addNewCustomers(CustomersRequest customersRequest) {
        return customersRepository.save(new Customers(customersRequest.getLastName(), customersRequest.getFirstName(), customersRequest.getSecondName(), customersRequest.getPhone(), customersRequest.getEmail(), customersRequest.getAdress(), customersRequest.getUsersId()));
    }
}
