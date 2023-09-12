package com.kceecode.quiz.app.repo;

import com.kceecode.quiz.app.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
