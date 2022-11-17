package com.javatechie.student;

import com.javatechie.student.entities.Profile;
import com.javatechie.student.respository.ProfileRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileService {
    private final ProfileRespository profileRespository;
    @Autowired
    public ProfileService(ProfileRespository profileRespository) {
        this.profileRespository = profileRespository;
    }




    public List<Profile> getProfile(){
        //without need to implement nothing from the methodes of the ProfileRespository interface we can use them because
        //of the JPARespository :
        return profileRespository.findAll();
    }



    public void addNewProfile(Profile profile) {
        Optional <Profile> profileOptional=profileRespository.findStudentByName(profile.getName());

        if(profileOptional.isPresent())
        {
            throw new IllegalStateException("name is taken");
        }
        profileRespository.save(profile);
    }



    public void deleteStudent(Long profileId) {
        Boolean exits=profileRespository.existsById(profileId);
        if (!exits)
            throw new IllegalStateException("student id = "+profileId+" does not exist");
        profileRespository.deleteById(profileId);
    }





    //using this annotation means that we won't use any of the Jpa queries
//    @Transactional
//    public void updateStudent(Long studentID, String name, String email) {
//
//        Optional <Student> student=studentRespository.findById(studentID);
//        Optional <Student> studentOptional=studentRespository.findStudentByEmail(email);
//
//
//        if (student == null )
//            throw new IllegalStateException("student id = "+studentID+" does not exist");
//
//
//        //student is type optional student so to get access to student methods we need to use the optional method : optionalStudent.get()
//        if (name!=null && name.length()>0 && !Objects.equals(name, student.get().getName()))
//            student.get().setName(name);
//
//
//        if (email!=null && email.length()>0 && !Objects.equals(email, student.get().getEmail()) ) {
//            if (studentOptional.isPresent()) {
//                throw new IllegalStateException("email is taken");
//            }
//
//
//            student.get().setEmail(email);
//        }
//    }
}
