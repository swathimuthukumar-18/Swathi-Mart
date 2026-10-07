package com.swathimart.swathi_mart;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SwathiMartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwathiMartApplication.class, args);
    }

    // Create default admin user
    @Bean
    CommandLineRunner createUser(UserRepository userRepository) {
        return args -> {

            if (userRepository.findByEmail("admin@gmail.com") == null) {

                User user = new User(
                    "Admin",
                    "admin@gmail.com",
                    "1234"
                );

                userRepository.save(user);

                System.out.println("Default admin user created.");
            }
        };
    }

    // Automatically open Login page after application starts
    @EventListener(ApplicationReadyEvent.class)
    public void openBrowser() {

        try {

            new ProcessBuilder(
                "cmd",
                "/c",
                "start",
                "",
                "http://localhost:8080/login"
            ).start();

            System.out.println("Login page opening in browser...");

        } catch (IOException e) {

            System.out.println("Could not open browser automatically.");
            e.printStackTrace();
        }
    }
}