package com.example.demo;

import com.example.demo.model.DeliveryuserModel;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DeliveryuserService {
    private final DeliveryuserRepository deliveryuserRepository;

    @Autowired
    public DeliveryuserService(DeliveryuserRepository deliveryuserRepository) {
        this.deliveryuserRepository = deliveryuserRepository;
    }

    public boolean signup(String name, String password) {
        // Check if user with the same email already exists
        if (deliveryuserRepository.findByName(name) != null) {
            return false; // Signup failed - User with the same email already exists
        }

        // Create a new user entity
        DeliveryuserModel user = new DeliveryuserModel();
        user.setName(name);
        user.setPassword(password);

        // Save the user entity to the database
        deliveryuserRepository.save(user);

        return true; // Signup successful
    }

    public boolean login(String name, String password) {
        DeliveryuserModel user = deliveryuserRepository.findByName(name);
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
