package com.survey.api.services;

import com.survey.api.Model.User;
import com.survey.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServices {
    private final UserRepository userRepository;

    @Autowired
    public UserServices (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User create (User user){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Hash the user's password
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public List<User> findAll (){
        return userRepository.findAll();
    }

}
