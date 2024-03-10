package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Customers;
import org.example.sbv.repository.CustomersRepository;
import org.example.sbv.repository.UsersRepository;
import org.example.sbv.request.CustomersRequest;
import org.example.sbv.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;
    private final UsersService usersService;
    private final UsersRepository usersRepository;
    @Autowired
    public CustomersService(CustomersRepository customersRepository, UsersService usersService, UsersRepository usersRepository) {
        this.customersRepository = customersRepository;
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }
    public List<CustomerResponse> getAllCustomersByUsers(HttpServletRequest request) {
        Integer userId = usersService.getUserIdByJWT(request);
        if (userId != null) {
            List<CustomerResponse> customerResponses = new ArrayList<>();
            for (Customers customers:customersRepository.findCustomersByUsersId_Id(userId)) {
                customerResponses.add(new CustomerResponse(customers.getId(), customers.getFirstName(), customers.getLastName(), customers.getSecondName(), customers.getPhone(), customers.getEmail(), customers.getAdress(),  customers.getUsersId().getId()));
            } ;
            return customerResponses;
        }
        else return null;
    }

    public CustomerResponse getCustomerById(HttpServletRequest request, Integer id) {
        Integer userId = usersService.getUserIdByJWT(request);
        if (userId != null) {
            Customers customer = customersRepository.findCustomersByIdAndUsersId_Id(id, userId);
            return new CustomerResponse(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getSecondName(), customer.getPhone(), customer.getEmail(), customer.getAdress(), customer.getUsersId().getId());
        }
        else return null;
    }
    public CustomerResponse addNewCustomers(HttpServletRequest request, CustomersRequest customersRequest) {
        Integer userId = usersService.getUserIdByJWT(request);
        if (userId != null) {
            Customers customers = customersRepository.save(new Customers(customersRequest.getLastName(), customersRequest.getFirstName(), customersRequest.getSecondName(), customersRequest.getPhone(), customersRequest.getEmail(), customersRequest.getAdress(), usersRepository.findUsersById(userId)));
            return new CustomerResponse(customers.getId(), customers.getFirstName(), customers.getLastName(), customers.getSecondName(), customers.getPhone(), customers.getEmail(), customers.getAdress(),  customers.getUsersId().getId());
        }
        else return null;
    }
}
