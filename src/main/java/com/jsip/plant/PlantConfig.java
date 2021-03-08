package com.jsip.plant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class PlantConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlantRepository repository){
        return args -> {
            Plant jasmine = new Plant("Jasmine", "2 days ago", "Every 7 days");
            Plant rose = new Plant("Rose", "3 days ago", "Every 4 days");

            //repository.saveAll(Arrays.asList(jasmine, rose));
        };
    }
}
