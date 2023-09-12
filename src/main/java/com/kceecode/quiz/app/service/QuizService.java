package com.kceecode.quiz.app.service;

import com.kceecode.quiz.app.model.Question;
import com.kceecode.quiz.app.model.QuestionWrapper;
import com.kceecode.quiz.app.model.Quiz;
import com.kceecode.quiz.app.model.Response;
import com.kceecode.quiz.app.repo.QuestionRepository;
import com.kceecode.quiz.app.repo.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {
    private  final QuizRepository quizRepository;
    private  final QuestionRepository questionRepository;
    public  Quiz
    createQuiz(String category, Integer noOfQues, String title) {
        List<Question> questionList = questionRepository.findRandomQuestionsByCat(category, noOfQues);
        System.out.println("<>>" + questionList);
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestionList(questionList);
       return quizRepository.save(quiz);

    }

    public List<QuestionWrapper> getQuizQuestions(Long id) {
      Optional<Quiz> quiz = quizRepository.findById(id);
      List<Question> questionsFromDb = quiz.get().getQuestionList();
      List<QuestionWrapper> questionForUsers = new ArrayList<>();

      for (Question q: questionsFromDb){
          QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(),
                  q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
          questionForUsers.add(qw);

      }
      return questionForUsers;
    }

    public Integer QuizScore(Long id, List<Response> responses) {
        //get the quiz object
           Quiz quiz = quizRepository.findById(id).get();
           List<Question> questions = quiz.getQuestionList();
           int right = 0;
           int i = 0;

           for (Response res : responses){
               // Check if the response is equal to the correct answer
                 if (res.getResponse().equals(questions.get(i).getRightAnswer())){
                  // continue;
                     right++;


                 }
               // Increment i for the next question
                 i++;

           }

           return  right;
    }
}
