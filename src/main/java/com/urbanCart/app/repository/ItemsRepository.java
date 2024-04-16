package com.urbanCart.app.repository;

import com.urbanCart.app.entity.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository<Item, ObjectId> {

}
