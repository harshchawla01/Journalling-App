package net.harsh.journalApp.repository;

import net.harsh.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository<Entity type, ID type>
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}

// controller ---> service ---> repository