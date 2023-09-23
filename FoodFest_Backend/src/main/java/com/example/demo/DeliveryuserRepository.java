package com.example.demo;
import com.example.demo.model.DeliveryuserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryuserRepository  extends JpaRepository<DeliveryuserModel, Long> {
    // Additional methods for custom queries or operations can be defined here
    DeliveryuserModel findByName(String name);
}
