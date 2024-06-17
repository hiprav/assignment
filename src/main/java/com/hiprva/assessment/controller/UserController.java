package com.hiprva.assessment.controller;

import com.hiprva.assessment.Repo.UserRepo;
import com.hiprva.assessment.exception.UserNotFoundException;
import com.hiprva.assessment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User userEntity) {
         String hashedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(hashedPassword);
        userRepository.save(userEntity);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetchUser(@RequestParam String username) {
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return ResponseEntity.ok(userEntity);
        } else {
            throw new UserNotFoundException("User not found with username: " + username);
        }
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}
