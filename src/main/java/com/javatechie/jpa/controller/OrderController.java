package com.javatechie.jpa.controller;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.*;
import com.javatechie.jpa.repository.ProfileRepository;
import com.javatechie.jpa.repository.UserRepository;
import com.javatechie.jpa.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private ProfileRepository profileRespository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileService profileService;

    @PostMapping("/placeOrder")
    public Profile placeOrder(@RequestBody OrderRequest request){


        return profileService.addProfile(request);
    }




    @PostMapping("/addUser")
    public Profile addUser(@RequestParam Long profileId, @RequestBody User user){


       return profileService.addUserToProfile(profileId, user);
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestParam Long profileID, @RequestBody Profile profile)
    {
        profileService.updateProfile(profileID, profile);
    }


    @GetMapping("/findAllProfiles")
    public List<Profile> findAllProfiles(){

        return profileService.getAllProfiles();
    }




    @GetMapping("/getProfileByUserId")
    public List<OrderResponse> getProfileByUserId(@RequestParam int id){
        return profileService.getProfileByUserId(id);
    }

    @GetMapping("/deleteProfile")
    public List<Profile> deleteProfile(@RequestParam Long profileID)
    {
        return profileService.deleteProfile(profileID);
    }





    //to delete a product we need : first to have the product id, to use it to find the customer id which is
    //a foreign key to the customer table, and then search the current product in the list of products and delete it
    @Transactional
    @GetMapping("/deleteUser")
    public void deleteUser(@RequestParam int id){
        profileService.deleteUserFromProfile(id);

//        return  orderResponses.get(0).getCid();
//        OrderResponse orderResponse;
//        int cid=-1;
//        for(OrderResponse orderResponse1: orderResponses) {
//            if (orderResponse1.getPid() == id) cid = orderResponse1.getCid();
//        }
//        return cid;

    }

}
