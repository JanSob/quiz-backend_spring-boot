package com.jansob.spring.quizbackend.question;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionConfig {

    @Bean
    CommandLineRunner commandLineRunner(QuestionRepository questionRepository){
        return args -> {
            Question skyQuestion = new Question(1L, "What color is the sky?", "blue", List.of("cyan", "green", "purple"),3);
            Question waterQuestion = new Question(2L, "In what state is water at -10° Celsius on Earth at sea-level?", "solid", List.of("liquid", "gaseous", "plasma"),1);
            Question spiceQuestion = new Question(3L, "Is chilli hot?", "yes", List.of("no"),1);
            Question sweetQuestion = new Question(4L, "Are sweets usually sweet?", "yes", List.of("no"),1);
            questionRepository.saveAll(List.of(skyQuestion, waterQuestion, spiceQuestion, sweetQuestion));
        };
    }
}
