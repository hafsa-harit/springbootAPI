package com.javatechie.jpa.services;

import com.javatechie.jpa.entity.Profile;
import com.javatechie.jpa.entity.User;
import com.javatechie.jpa.repository.ProfileRepository;
import com.javatechie.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProfileService {
    private final UserRepository productRepository;
    private final ProfileRepository customerRepository;
    @Autowired
    public ProfileService(ProfileRepository customerService, UserRepository productRepository) {
        this.customerRepository = customerService;
        this.productRepository = productRepository;
    }
    //productService :


    @Transactional
    public Profile update(Long customerId, User product)
    {
        Optional<Profile> optionalCustomer= customerRepository.findById(Math.toIntExact(customerId));
        if(optionalCustomer.isPresent())
            optionalCustomer.get().getUsers().add(product);



        return optionalCustomer.get();
    }





}
