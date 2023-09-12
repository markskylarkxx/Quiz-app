package com.kceecode.quiz.app.repo;

import com.kceecode.quiz.app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository  extends JpaRepository<Question, Long> {
   Optional<Question> findByQuestionTitle(String question);

   List<Question> findByCategory(String category);
@Query(value = "select  * from  question q where q.category=:category order by rand() limit :noOfQues", nativeQuery = true)
   List<Question> findRandomQuestionsByCat(String category, Integer noOfQues);
   @Query(value = "select  * from  question q where  q.category=:cat order by rand() limit :noOfQues", nativeQuery = true)
   List<Question> findByCatAndNo(String cat, Integer noOfQues);
}
