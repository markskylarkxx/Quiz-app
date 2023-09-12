package com.kceecode.quiz.app.resource;

import com.kceecode.quiz.app.model.Question;
import com.kceecode.quiz.app.repo.QuestionRepository;
import com.kceecode.quiz.app.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
public class QuestionController{

    private  final QuestionService service;

    // add question;
       @PostMapping("/add")
    public ResponseEntity<Question> addQuestions(@RequestBody Question questionRequest){
          Question questions = service.addQuestions(questionRequest);
         return new ResponseEntity<>(questions, HttpStatus.CREATED);
    }

    //get  all questions;
    @GetMapping("/questions")
    public  ResponseEntity<List<Question>> allQuestions(){
           try {
               List<Question> allQuestions = service.allQuestions();
               return  new ResponseEntity<>(allQuestions, HttpStatus.OK);
           }catch (Exception exception){
               exception.printStackTrace();

           }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }
    // get question by category

    @GetMapping("category/{category}")
    public  ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
           List<Question> questionsByCategory = service.questionsByCategory(category);
        System.out.println(questionsByCategory.size());
           return  new ResponseEntity<>(questionsByCategory, HttpStatus.OK);
    }
    private  final QuestionRepository repository;

    // get question with specific number
    @GetMapping("/retrieve")
    public  List<Question> getSpecificQuestionNumber(@RequestParam String cat, @RequestParam Integer noOfQues ){
        return  repository.findByCatAndNo(cat, noOfQues);
    }

}
