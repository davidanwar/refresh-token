package com.agriku.token;

import com.agriku.token.domain.RoleEntity;
import com.agriku.token.domain.UserEntity;
import com.agriku.token.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class RefreshTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefreshTokenApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new RoleEntity(null, "ROLE_USER"));
            userService.saveRole(new RoleEntity(null, "ROLE_ADMIN"));
            userService.saveRole(new RoleEntity(null, "ROLE_MANAGER"));
            userService.saveRole(new RoleEntity(null, "ROLE_SUPER_ADMIN"));
            userService.saveUser(new UserEntity(null, "David Anwar", "david", "12345", new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "David Anwar", "anwar", "12345", new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "David Anwar", "bocil", "12345", new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "David Anwar", "zaki", "12345", new ArrayList<>()));

            userService.addRoleToUser("david", "ROLE_MANAGER");
            userService.addRoleToUser("david", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("anwar", "ROLE_ADMIN");
            userService.addRoleToUser("bocil", "ROLE_USER");
            userService.addRoleToUser("zaki", "ROLE_ADMIN");
        };
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
