package com.javatechie.student;

import com.javatechie.student.entities.Profile;
import com.javatechie.student.entities.User;
import com.javatechie.student.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;

    public List<User> getUser(){
        //without need to implement nothing from the methodes of the ProfileRespository interface we can use them because
        //of the JPARespository :
        return userRespository.findAll();
    }




    public void addNewUser(User user) {
        Optional<User> userOptional=userRespository.findUserByName(user.getName());

        if(userOptional.isPresent())
        {
            throw new IllegalStateException("name is taken");
        }
        userRespository.save(user);
    }

}
