package com.example.demo;
import com.example.demo.ItemsalesRepository;
import com.example.demo.model.ItemsalesModel;
import com.example.demo.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsalesService {
    private final ItemsalesRepository itemsalesRepository;

    @Autowired
    public ItemsalesService(ItemsalesRepository itemsalesRepository) {
        this.itemsalesRepository = itemsalesRepository;
    }
    public boolean eachItemIncrease(String name, String quantity) {
        ItemsalesModel itemsales = itemsalesRepository.findByName(name);
        if (itemsales != null) {
            int currentQuantity = itemsales.getQuantity();
            int additionalQuantity = Integer.parseInt(quantity);
            int newQuantity = currentQuantity + additionalQuantity;
            itemsales.setQuantity(newQuantity);
            itemsalesRepository.save(itemsales);
            return true; // Update successful
        }
        else {
            // Create a new order entity
            itemsales = new ItemsalesModel();
            itemsales.setName(name);
            itemsales.setQuantity(Integer.parseInt(quantity));
            itemsalesRepository.save(itemsales);
            return true; // Insert successful
        }
    }

    public List<ItemsalesModel> getAllEachitemSales() {
        return (List<ItemsalesModel>) itemsalesRepository.findAll();
    }

}
