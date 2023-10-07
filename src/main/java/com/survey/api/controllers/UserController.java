package com.survey.api.controllers;

import com.survey.api.Model.User;
import com.survey.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/validate/username/{username}")
    public boolean isValidUsername (@PathVariable String username){

        boolean usernameExists = userServices.isUsernameAlreadyExists(username);
        // if username exists than the username is not valid
       return (!usernameExists);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllCourses(){
        userServices.deleteAllUsers();
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/validate/email/{email}")
    public ResponseEntity<?> isValidEmail (@PathVariable String email){

        boolean emailExists = userServices.isEmailAlreadyExists(email);
        // if email exists than the email is not valid
         if(emailExists){
             return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists.");
         }
        return ResponseEntity.ok("Email is available.");

    }


}
