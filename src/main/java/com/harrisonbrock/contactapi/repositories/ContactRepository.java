package com.harrisonbrock.contactapi.repositories;

import com.harrisonbrock.contactapi.models.Contacts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contacts, String> {
}
