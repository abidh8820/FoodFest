package com.example.demo;
import com.example.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    // Additional methods for custom queries or operations can be defined here
    UserModel findByName(String name);
}
