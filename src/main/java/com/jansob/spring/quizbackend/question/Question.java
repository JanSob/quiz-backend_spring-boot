package com.jansob.spring.quizbackend.question;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Question {
    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "quiz_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quiz_sequence"
    )
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String question;

    @NotBlank
    private String correct;


    @ElementCollection
    @Column
    private List<String> wrong = new java.util.ArrayList<>();


    @NotNull
    @Range(min = 1, max = 5)
    private Integer difficulty;


    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    // Constructor for sample-data
    public Question(Long id, String question, String correct, List<String> wrong, Integer difficulty) {
        this.id = id;
        this.question = question;
        this.correct = correct;
        this.wrong = wrong;
        this.difficulty = difficulty;
    }
}
