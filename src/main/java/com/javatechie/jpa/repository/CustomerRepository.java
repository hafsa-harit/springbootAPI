package com.javatechie.jpa.repository;

import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   @Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.id , p.pid) FROM Customer c JOIN c.products p WHERE p.pid=?1")
    public List<OrderResponse> getJoinInformation(int id);


}
