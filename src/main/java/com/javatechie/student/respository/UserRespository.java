package com.javatechie.student.respository;

import com.javatechie.student.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User,Long> {
    @Query("SELECT s FROM User s WHERE s.name =?1")
    Optional<User> findUserByName(String name);
}
