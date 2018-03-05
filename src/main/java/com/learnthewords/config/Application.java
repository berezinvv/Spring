package com.learnthewords.config;

import com.learnthewords.entity.Word;
import com.learnthewords.repository.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.learnthewords.repository")
@EntityScan("com.learnthewords.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(WordRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Word("Jack"));
            repository.save(new Word("Chloe"));
            repository.save(new Word("Kim"));
            repository.save(new Word("David"));
            repository.save(new Word("Michelle"));
        };
    }
}