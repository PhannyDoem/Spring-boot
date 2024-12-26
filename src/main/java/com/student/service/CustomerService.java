package com.student.service;

import com.student.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Optional<Customer> getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(long id, Customer customer);

    String deleteCustomer(long id);
}
