package com.urbanCart.app.service;

import com.urbanCart.app.entity.Item;
import com.urbanCart.app.repository.ItemsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public void saveItem(Item item){
        itemsRepository.save(item);
    }

    public List<Item> getAllItemFromDB(){
        return itemsRepository.findAll();
    }

    public Optional<Item> getItemByIdFromDB(ObjectId id){
        return itemsRepository.findById(id);
    }

    public void deleteItemById(ObjectId id){
        itemsRepository.deleteById(id);
    }

}
