package com.kceecode.quiz.app.service;


import com.kceecode.quiz.app.model.Question;
import com.kceecode.quiz.app.repo.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
      private  final QuestionRepository repository;
    public  Question addQuestions(Question questionRequest) {
        // check if question title exist
        Optional<Question> optional = repository.findByQuestionTitle(questionRequest.getQuestionTitle());
        if (optional.isPresent())
        {
            throw  new IllegalStateException("Question already present in the database");

        }
        Question question = new Question(questionRequest.getQuestionTitle(),
                questionRequest.getOption1(), questionRequest.getOption2(), questionRequest.getOption3(),
                questionRequest.getOption4(), questionRequest.getRightAnswer(), questionRequest.getDifficultyLevel(), questionRequest.getCategory());
        // save the question;
      return   repository.save(question);

    }

    public List<Question> allQuestions() {
       return  repository.findAll();
    }

    public List<Question> questionsByCategory(String category) {
        return  repository.findByCategory(category);
    }
}
