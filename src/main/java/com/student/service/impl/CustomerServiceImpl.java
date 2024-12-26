package com.student.service.impl;

import com.student.model.Customer;
import com.student.repository.CustomerRepository;
import com.student.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(long id, Customer customer) {
        return customerRepository.findById(id)
                .map(customer1 -> {
                    customer1.setFirstName(customer.getFirstName());
                    customer1.setLastName(customer.getLastName());
                    customer1.setEmail(customer.getEmail());
                    customer1.setPhoneNumber(customer.getPhoneNumber());
                    return customerRepository.save(customer1);
                }).orElse( null);
    }

    @Override
    public String deleteCustomer(long id) {
        customerRepository.deleteById(id);
        return "Customer Deleted Successfully";
    }
}
