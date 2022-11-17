package com.javatechie.student.respository;

import com.javatechie.student.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//responsible for data access :
@Repository
public interface ProfileRespository extends JpaRepository<Profile,Long> {
    @Query("SELECT s FROM Profile s WHERE s.name =?1")
    Optional<Profile> findStudentByName(String name);
}
