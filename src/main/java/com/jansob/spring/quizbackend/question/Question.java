package com.jansob.spring.quizbackend.question;
import java.time.LocalDateTime;
import java.util.Arrays;


public class Question {
    private Long id;
    private String question;
    private String correct;
    private String[] wrong;
    private Integer difficulty;
    private LocalDateTime created;

    public Question() {
    }

    public Question(Long id, String question, String correct, String[] wrong,
                    Integer difficulty, LocalDateTime created) {
        this.id = id;
        this.question = question;
        this.correct = correct;
        this.wrong = wrong;
        this.difficulty = difficulty;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String[] getWrong() {
        return wrong;
    }

    public void setWrong(String[] wrong) {
        this.wrong = wrong;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", correct='" + correct + '\'' +
                ", wrong=" + Arrays.toString(wrong) +
                ", difficulty=" + difficulty +
                ", created=" + created +
                '}';
    }
}
