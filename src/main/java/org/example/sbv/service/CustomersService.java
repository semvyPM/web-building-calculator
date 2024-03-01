package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Customers;
import org.example.sbv.repository.CustomersRepository;
import org.example.sbv.repository.UsersRepository;
import org.example.sbv.request.CustomersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<Customers> getAllCustomersByUsers(HttpServletRequest request) {
        System.out.println(usersService.getUserIdByJWT(request));
        return customersRepository.findCustomersByUsersId_Id(usersService.getUserIdByJWT(request));
    }

    public Customers getCustomerById(HttpServletRequest request, Integer id) {
        Integer userid = usersService.getUserIdByJWT(request);
        return customersRepository.findCustomersByIdAndUsersId_Id(id, userid);
    }
    public Customers addNewCustomers(HttpServletRequest request, CustomersRequest customersRequest) {
        Integer id = usersService.getUserIdByJWT(request);
        return customersRepository.save(new Customers(customersRequest.getLastName(), customersRequest.getFirstName(), customersRequest.getSecondName(), customersRequest.getPhone(), customersRequest.getEmail(), customersRequest.getAdress(), usersRepository.findUsersById(id)));
    }
}
