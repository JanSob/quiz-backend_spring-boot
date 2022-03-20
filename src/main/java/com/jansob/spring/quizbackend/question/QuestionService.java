package com.jansob.spring.quizbackend.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    public void addQuestion(Question question) {
        Optional<Question> existingQuestion = questionRepository.findQuestionByQuestion(question.getQuestion());
        if(existingQuestion.isPresent()){
            throw new IllegalStateException("Question already exists in DB");
        }
        questionRepository.save(question);
    }

    public void deleteQuestion(Long questionId) {
        if(!questionRepository.existsById(questionId)){
            throw new IllegalStateException("Question with ID " + questionId + " does not exist, can't delete!");
        }
        questionRepository.deleteById(questionId);
    }

    @Transactional
    public void updateQuestion(Question question) {
        if(question.getId() == null) throw new IllegalStateException("No id");
        Question updateQuestion = questionRepository.findById(question.getId())
                .orElseThrow(() -> new IllegalStateException("Question with ID " + question.getId() + " does not exist, can't update!"));
        if(question.getQuestion() != null && questionRepository.findQuestionByQuestion(question.getQuestion()).isPresent()){
            throw new IllegalStateException("This question already exists in the DB, can't update otherwise duplication!");
        }
        if(question.getQuestion() != null){updateQuestion.setQuestion(question.getQuestion());}
        if(question.getCorrect() != null){updateQuestion.setCorrect(question.getCorrect());}
        if(!question.getWrong().isEmpty()){updateQuestion.setWrong(question.getWrong());}
        if(question.getDifficulty() != null){updateQuestion.setDifficulty(question.getDifficulty());}
    }
}