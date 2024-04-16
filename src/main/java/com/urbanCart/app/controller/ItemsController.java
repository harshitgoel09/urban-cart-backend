package com.urbanCart.app.controller;

import com.urbanCart.app.entity.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    private HashMap<String, Item> itemMap = new HashMap<>();

    @GetMapping("/all")
    private List<Item> getAllItem(){
        return new ArrayList<>(itemMap.values());
    }

    @GetMapping("/{item_id}")
    public Item getItemById(@PathVariable String item_id){
        return itemMap.get(item_id);
    }

    @PostMapping("/create")
    public boolean createItem(@RequestBody Item currentItem){
        itemMap.put(currentItem.getItem_id(), currentItem);
        return true;
    }

    @PutMapping("/update/{item_id}")
    public Item updateItem(@PathVariable String item_id, @RequestBody Item modifiedItem){
        itemMap.put(item_id, modifiedItem);
        return itemMap.get(item_id);
    }

    @DeleteMapping("/delete/{item_id}")
    public boolean deleteItem(@PathVariable String item_id){
        itemMap.remove(item_id);
        return true;
    }
}
