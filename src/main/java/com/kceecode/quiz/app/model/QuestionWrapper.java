package com.kceecode.quiz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class QuestionWrapper {
    private Long id;
    private  String questionTitle;
    private  String option1;
    private  String option2;
    private  String option3;
    private  String option4;

}
