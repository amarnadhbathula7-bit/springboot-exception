package com.amar.springBootEXceptionhandlingCustomer.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amar.springBootEXceptionhandlingCustomer.exception.CustomerAlreadyExistsException;
import com.amar.springBootEXceptionhandlingCustomer.exception.NoSuchCustomerExistsException;
import com.amar.springBootEXceptionhandlingCustomer.model.Customer;
import com.amar.springBootEXceptionhandlingCustomer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(
                    () -> new NoSuchElementException(
                        "NO CUSTOMER PRESENT WITH ID = " + id
                    )
                );
    }

    @Override
    public String addCustomer(Customer customer) {

        Optional<Customer> existingCustomer =
                customerRepository.findByEmail(customer.getEmail());

        if (existingCustomer.isPresent()) {

            throw new CustomerAlreadyExistsException(
                    "Customer already exists with email = "
                            + customer.getEmail()
            );
        }

        customerRepository.save(customer);

        return "Customer added successfully";
    }
    @Override
    public String updateCustomer(Customer customer) {

        Optional<Customer> existingCustomer =
                customerRepository.findById(customer.getId());

        if (!existingCustomer.isPresent()) {

            throw new NoSuchCustomerExistsException(
                    "No Such Customer exists!!"
            );

        } else {

            existingCustomer.get().setName(customer.getName());
            existingCustomer.get().setAddress(customer.getAddress());

            customerRepository.save(existingCustomer.get());

            return "Record updated Successfully";
        }
    }
}