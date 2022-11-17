package com.javatechie.jpa.services;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Profile;
import com.javatechie.jpa.entity.User;
import com.javatechie.jpa.repository.ProfileRepository;
import com.javatechie.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    @Autowired
    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }
    //profiletService :


    @Transactional
    public Profile addUserToProfile(Long customerId, User user)
    {    //find the profile
        //add the user to the  list
        Optional<Profile> optionalCustomer= profileRepository.findById(Math.toIntExact(customerId));
        if(optionalCustomer.isPresent())
            optionalCustomer.get().getUsers().add(user);

        return optionalCustomer.get();
    }


    public Profile addProfile(OrderRequest request) {

        return profileRepository.save(request.getProfile());
    }


    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }


    public List<OrderResponse> getProfileByUserId(int id) {
        return profileRepository.getJoinInformation(id);

    }
    @Transactional
    public void deleteUserFromProfile(int id) {
        List<OrderResponse> orderResponses = profileRepository.getJoinInformation(id);
        if(orderResponses.size()==0)

            throw new IllegalStateException("Product does not exist");

        Optional<Profile> optionalCustomer=profileRepository.findById(orderResponses.get(0).getCid());
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
    }
    @Transactional
    public void updateProfile(Long profileID, Profile profile) {
        Optional<Profile> optionalCustomer=profileRepository.findById(Math.toIntExact(profileID));
        optionalCustomer.get().setName(profile.getName());
        optionalCustomer.get().setAccess1(profile.getAccess1());
        optionalCustomer.get().setAccess2(profile.getAccess2());


    }

    public List<Profile> deleteProfile(Long profileID) {
        Optional<Profile> optionalCustomer=profileRepository.findById(Math.toIntExact(profileID));
         profileRepository.delete(optionalCustomer.get());
         return profileRepository.findAll();
    }
}
