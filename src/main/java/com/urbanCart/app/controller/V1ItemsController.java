package com.urbanCart.app.controller;

import com.urbanCart.app.entity.Item;
import com.urbanCart.app.service.ItemsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/items")
public class V1ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping("/all")
    private List<Item> getAllItem(){
        return itemsService.getAllItemFromDB();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable ObjectId id){
        return itemsService.getItemByIdFromDB(id).orElse(null);
    }

    @PostMapping("/create")
    public boolean createItem(@RequestBody Item currentItem){
        currentItem.setDate(LocalDateTime.now());
        itemsService.saveItem(currentItem);
        return true;
    }

    @PutMapping("/update/{id}")
    public Item updateItem(@PathVariable ObjectId id, @RequestBody Item modifiedItem){
        modifiedItem.setDate(LocalDateTime.now());
        Item currentItem = itemsService.getItemByIdFromDB(id).orElse(null);
        if(currentItem != null){
            currentItem = modifiedItem;
            itemsService.saveItem(currentItem);
        } else {
            itemsService.saveItem(modifiedItem);
        }

        return modifiedItem;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteItem(@PathVariable ObjectId id){
        itemsService.deleteItemById(id);
        return true;
    }

}
