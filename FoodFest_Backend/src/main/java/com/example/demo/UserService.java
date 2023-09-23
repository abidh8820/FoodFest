package com.example.demo;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean signup(String name, String email, String password) {
        // Check if user with the same email already exists
        if (userRepository.findByName(name) != null) {
            return false; // Signup failed - User with the same email already exists
        }

        // Create a new user entity
        UserModel user = new UserModel();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        // Save the user entity to the database
        userRepository.save(user);

        return true; // Signup successful
    }

    public boolean login(String name, String password) {
        UserModel user = userRepository.findByName(name);
        //right credentials
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        else{
            //System.out.println("Hello, world!");
            //wrong credentials
            return false;
        }
    }
}

