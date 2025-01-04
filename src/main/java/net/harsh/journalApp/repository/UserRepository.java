package net.harsh.journalApp.repository;

import net.harsh.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository<Entity type, ID type>
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username); // userService methods implement krta h userRepository ke... Aur userRepository extend krta h MongoRepository interface ko.

    // Ab MongoRepository me ye method hai nahi, to hum is nalle interface ka use kr rhe h ab pehli baar
}

// controller ---> service ---> repository