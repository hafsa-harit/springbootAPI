package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

//    @Query("SELECT s.cp_fk FROM product s WHERE s.id =?1")
//    public Long getFK(Long id);
}
