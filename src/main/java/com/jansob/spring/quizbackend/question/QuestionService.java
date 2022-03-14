package com.jansob.spring.quizbackend.question;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    public List<Question> getQuestions(){
        return List.of(new Question());
    }
}
