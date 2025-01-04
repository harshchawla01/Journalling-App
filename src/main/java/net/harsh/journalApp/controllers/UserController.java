package net.harsh.journalApp.controllers;

import net.harsh.journalApp.entity.User;
import net.harsh.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user") // Adds mapping to a class
public class UserController {
    // Won't allow duplicate ids, i.e., either it will alter

    @Autowired
    private UserService userService;


//    It must be an admin feature
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAll();
//    }

//    @PutMapping("/{userName}")
//    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName) {
//        User userInDb = userService.findByUsername(userName);
//        if (userInDb != null) {
//            userInDb.setUserName(user.getUserName());
//            userInDb.setPassword(user.getPassword());
//            userService.saveEntry(userInDb);
//            return new ResponseEntity<>(userInDb, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Kaisa hai bhai");
        String userName = authentication.getName();

        User userInDb = userService.findByUsername(userName);
        if (userInDb != null) { // unnecessary condition if Spring Security is used
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
            return new ResponseEntity<>(userInDb, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.deleteById(userService.findByUsername(authentication.getName()).getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}