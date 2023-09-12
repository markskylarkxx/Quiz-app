package com.kceecode.quiz.app.resource;

import com.kceecode.quiz.app.model.Question;
import com.kceecode.quiz.app.model.QuestionWrapper;
import com.kceecode.quiz.app.model.Quiz;
import com.kceecode.quiz.app.model.Response;
import com.kceecode.quiz.app.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {

    private  final QuizService service;

    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category,
                                             @RequestParam Integer noOfQues, @RequestParam String title){
           Quiz createQuiz = service.createQuiz(category, noOfQues, title);
           return  new ResponseEntity<>(createQuiz, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Long id){
       List<QuestionWrapper> quizQuestion = service.getQuizQuestions(id);
       return  new ResponseEntity<>(quizQuestion, HttpStatus.OK);


    }
    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submitQuiz(@PathVariable Long id, @RequestBody List<Response> responses){
        Integer score =   service.QuizScore(id, responses);
        return  new ResponseEntity<>(score, HttpStatus.CREATED);
    }

}
