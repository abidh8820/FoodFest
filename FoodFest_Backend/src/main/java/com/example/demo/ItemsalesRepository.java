package com.example.demo;
import com.example.demo.model.ItemsalesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsalesRepository  extends JpaRepository<ItemsalesModel, Long> {
    // Additional methods for custom queries or operations can be defined here
    ItemsalesModel findByName(String name);

}
