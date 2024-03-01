package org.example.sbv.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Customers;
import org.example.sbv.request.CustomersRequest;
import org.example.sbv.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class CustomersController {
    private final CustomersService customersService;
    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }


    @GetMapping("/by-user/{id}")
    @ResponseBody
    public List<Customers> getAllCustomersByUser(HttpServletRequest request, @PathVariable Integer id) {
        List<Customers> customers = customersService.getAllCustomersByUsers(request);
        return customers;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Customers getCustomerById(HttpServletRequest request, @PathVariable Integer id) {
        Customers customers = customersService.getCustomerById(request, id);
        System.out.println("CUSTOMERS BY USER --- " + customers.getFirstName());
        return customers;
    }

    @PostMapping("/create")
    @ResponseBody
    public Customers addNewCustomer(HttpServletRequest request, @RequestBody CustomersRequest customersRequest) {
        Customers customers = customersService.addNewCustomers(request, customersRequest);
        return customers;
    }
}
