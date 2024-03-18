package org.example.sbv.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.entity.Customers;
import org.example.sbv.request.CustomersRequest;
import org.example.sbv.response.CustomerResponse;
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
    public List<CustomerResponse> getAllCustomersByUser(HttpServletRequest request, @PathVariable Integer id) {
        return customersService.getAllCustomersByUsers(request);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CustomerResponse getCustomerById(HttpServletRequest request, @PathVariable Integer id) {
        return customersService.getCustomerById(request, id);
    }

    @PostMapping("/create")
    @ResponseBody
    public CustomerResponse addNewCustomer(HttpServletRequest request, @RequestBody CustomersRequest customersRequest) {
        return customersService.addNewCustomers(request, customersRequest);
    }

    @PutMapping("/update")
    @ResponseBody
    public CustomerResponse updateCustomer(HttpServletRequest request, @RequestBody Customers customers) {
        return customersService.updateCustomer(request, customers);
    }
}
