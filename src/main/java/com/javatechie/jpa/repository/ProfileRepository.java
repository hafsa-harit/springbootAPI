package com.javatechie.jpa.repository;

import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {

   @Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.id , p.pid) FROM Profile c JOIN c.users p WHERE p.pid=?1")
    public List<OrderResponse> getJoinInformation(int id);


}
