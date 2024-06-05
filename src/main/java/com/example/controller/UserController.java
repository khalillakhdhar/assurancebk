package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.entity.AuthRequest;
import com.example.entity.User;
import com.example.entity.Demande;
import com.example.entity.Convention;
import com.example.entity.Facture;
import com.example.service.JwtService;
import com.example.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Spring Security tutorials !!");
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
            if (authenticate.isAuthenticated()) {
                return ResponseEntity.ok(jwtService.generateToken(authRequest.getUserName()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user request");
        }
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/getUsers/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/getUser/{name}")
    public ResponseEntity<User> getOneUser(@PathVariable String name) {
        User user = userService.getOneUser(name);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/currentUser")
    public ResponseEntity<User> getCurrentUser() {
        User user = userService.getCurrentUser();
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/addDemande")
    public ResponseEntity<Demande> addDemande(@RequestBody Demande demande) {
        User currentUser = userService.getCurrentUser();
        System.out.println("Current User: " + currentUser.getEmail() + ", Role: " + currentUser.getRole());
        return ResponseEntity.ok(userService.addDemande(demande));
    }

    @PostMapping("/addConvention")
    public ResponseEntity<Convention> addConvention(@RequestBody Convention convention) {
        User currentUser = userService.getCurrentUser();
        System.out.println("Current User: " + currentUser.getEmail() + ", Role: " + currentUser.getRole());
        return ResponseEntity.ok(userService.addConvention(convention));
    }

    @PostMapping("/addFacture")
    public ResponseEntity<Facture> addFacture(@RequestBody Facture facture) {
        User currentUser = userService.getCurrentUser();
        System.out.println("Current User: " + currentUser.getEmail() + ", Role: " + currentUser.getRole());
        return ResponseEntity.ok(userService.addFacture(facture));
    }
}
