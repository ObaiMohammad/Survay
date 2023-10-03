package com.survey.api.controllers;

import com.survey.api.Model.Survey;
import com.survey.api.Model.User;
import com.survey.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServices userServices;

    public UserController (UserServices userServices){
         this.userServices = userServices;
    }

    @PostMapping
    public ResponseEntity<User> addSurvey (@RequestBody User user){

        userServices.create(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public List<User> findAll (){

        return  userServices.findAll();
    }

    @GetMapping("/{username}")
    public boolean validateUsername (@PathVariable String username){

        User user = userServices.findByUsername(username);
        if (user == null){
            return true;
        }
        return false;

    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllCourses(){
        userServices.deleteAllUsers();
        return ResponseEntity.ok("Deleted successfully");
    }

}
