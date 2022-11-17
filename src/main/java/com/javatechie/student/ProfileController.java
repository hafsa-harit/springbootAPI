package com.javatechie.student;

import com.javatechie.student.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/profile")// for navigate to " localhost:8072/api/v1/student "
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    //the fact that this controller is a RestController get us the possibility t not
    //define the object retunred from this method by the annotation : @RispenseBody
    @GetMapping
    public List<Profile> getProfiles() {
        return profileService.getProfile();
    }
    @PostMapping
    public  void saveProfile(@RequestBody Profile profile)
    {
        profileService.addNewProfile(profile);
    }
}
