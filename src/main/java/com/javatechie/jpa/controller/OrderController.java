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
       return profileRespository.save(request.getProfile());
    }

    @PostMapping("/addProduct")
    public Profile placeOrder(@RequestParam Long customerId, @RequestBody User product){
        //find the custumer
        //add the product to the  list

       return profileService.update(customerId, product);
    }

    @GetMapping("/findAllProfiles")
    public List<Profile> findAllProfiles(){
        return profileRespository.findAll();
    }


    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(@RequestParam int id){
        return profileRespository.getJoinInformation(id);
    }
    //to delete a product we need : first to have the product id, to use it to find the customer id which is
    //a foreign key to the customer table, and then search the current product in the list of products and delete it
    @Transactional
    @GetMapping("/getCId")
    public void getCId(@RequestParam int id){
        List<OrderResponse> orderResponses = profileRespository.getJoinInformation(id);
        if(orderResponses.size()==0)

            throw new IllegalStateException("Product does not exist");

        Optional<Profile> optionalCustomer=profileRespository.findById(orderResponses.get(0).getCid());
        if(optionalCustomer==null)

            throw new IllegalStateException("Product does not exist");

        List<User> userList=optionalCustomer.get().getUsers();
        if(userList.size()==0)

            throw new IllegalStateException("List is empty");

        int index=0;

        for (User p: userList) {
            if (p.getPid()==id)break;//userList.remove(index);
            index++;

        }
        userList.remove(index);

//        return  orderResponses.get(0).getCid();
//        OrderResponse orderResponse;
//        int cid=-1;
//        for(OrderResponse orderResponse1: orderResponses) {
//            if (orderResponse1.getPid() == id) cid = orderResponse1.getCid();
//        }
//        return cid;

    }

}
