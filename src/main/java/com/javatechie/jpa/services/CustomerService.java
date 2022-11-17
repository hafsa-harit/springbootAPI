package com.javatechie.jpa.services;

import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.entity.Product;
import com.javatechie.jpa.repository.CustomerRepository;
import com.javatechie.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerService, ProductRepository productRepository) {
        this.customerRepository = customerService;
        this.productRepository = productRepository;
    }
    //productService :


    @Transactional
    public Customer update(Long customerId, Product product)
    {
        Optional<Customer> optionalCustomer= customerRepository.findById(Math.toIntExact(customerId));
        if(optionalCustomer.isPresent())
            optionalCustomer.get().getProducts().add(product);



        return optionalCustomer.get();
    }





}
