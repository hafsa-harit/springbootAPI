package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {

//    @Query("SELECT s.cp_fk FROM product s WHERE s.id =?1")
//    public Long getFK(Long id);
}
