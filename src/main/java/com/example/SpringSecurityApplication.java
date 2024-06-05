package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.entity.User;
import com.example.entity.Adresse;
import com.example.entity.Genre;
import com.example.entity.Role;
import com.example.service.UserService;

@SpringBootApplication
public class SpringSecurityApplication  {



    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

   
}
