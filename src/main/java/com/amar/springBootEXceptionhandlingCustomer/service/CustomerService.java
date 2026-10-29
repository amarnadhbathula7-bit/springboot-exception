package com.amar.springBootEXceptionhandlingCustomer.service;

import com.amar.springBootEXceptionhandlingCustomer.model.Customer;

public interface CustomerService {

    Customer getCustomer(Long id);

    String addCustomer(Customer customer);

    String updateCustomer(Customer customer);
}