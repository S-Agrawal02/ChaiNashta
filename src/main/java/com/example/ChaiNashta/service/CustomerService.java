package com.example.ChaiNashta.service;

import com.example.ChaiNashta.entity.Customer;
import com.example.ChaiNashta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findByCustomerId(Integer customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    public Optional<Customer> findByCustomerIdAndPassword(Integer customerId, String password) {
        return customerRepository.findByCustomerIdAndPassword(customerId, password);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

}
