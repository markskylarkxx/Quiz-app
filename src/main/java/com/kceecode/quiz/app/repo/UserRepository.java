package com.kceecode.quiz.app.repo;

import com.kceecode.quiz.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
