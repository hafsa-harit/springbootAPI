package com.javatechie.jpa.controller;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.entity.Product;
import com.javatechie.jpa.repository.CustomerRepository;
import com.javatechie.jpa.repository.ProductRepository;
import com.javatechie.jpa.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
       return customerRepository.save(request.getCustomer());
    }

    @PostMapping("/addProduct")
    public Customer placeOrder(@RequestParam Long customerId, @RequestBody Product product){
        //find the custumer
        //add the product to the  list

       return customerService.update(customerId, product);
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }


    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(@RequestParam int id){
        return customerRepository.getJoinInformation(id);
    }
    @GetMapping("/getCId")
    public int getCId(@RequestParam int id){
        List<OrderResponse> orderResponses = customerRepository.getJoinInformation(id);
        if(orderResponses.size()==0)
            throw new IllegalStateException("Product does not exist");
        return  orderResponses.get(0).getCid();
//        OrderResponse orderResponse;
//        int cid=-1;
//        for(OrderResponse orderResponse1: orderResponses) {
//            if (orderResponse1.getPid() == id) cid = orderResponse1.getCid();
//        }
//        return cid;

    }

}
