package org.example.sbv.controller;

import org.example.sbv.entity.Customers;
import org.example.sbv.response.CustomersRequest;
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

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Customers>> getAllCustomers() {
        List<Customers> customers = customersService.getAllCustomers();
        if (customers != null) {
            return ResponseEntity.ok(customers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-user/{id}")
    @ResponseBody
    public ResponseEntity<List<Customers>> getAllCustomersByUser(@PathVariable Integer id) {
        List<Customers> customers = customersService.getAllCustomersByUsers(id);
        if (customers != null) {
            return ResponseEntity.ok(customers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) {
        Customers customers = customersService.getCustomerById(id);
        if (customers != null) {
            System.out.println(customers.getLastName());
            return ResponseEntity.ok(customers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Customers> addNewCustomer(@RequestBody CustomersRequest customersRequest) {
        System.out.println(customersRequest.toString());
        Customers customers = customersService.addNewCustomers(customersRequest);
        if (customers != null) {
            System.out.println(customers.getLastName());
            return ResponseEntity.ok(customers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
