package com.example.ex2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppJavaConfig {
    @Bean
    UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean(name = "lightweight")
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder();
    }

    @Bean
    UserService userService() {
        return new UserServiceImpl(userRepository(), passwordEncoder());
    }

    @Bean
    UserService userService(UserRepository repository, PasswordEncoder encoder) {
        return new UserServiceImpl(repository, encoder);
    }
}
