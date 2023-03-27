package com.motilio.cart.dl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig{
    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerDatabase();
    }

    @Bean
    public ItemRepository itemRepository(){
        return new ItemDatabase();
    }
}