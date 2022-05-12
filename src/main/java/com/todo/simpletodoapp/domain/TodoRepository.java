package com.todo.simpletodoapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

    // 내가 쓴 todo만 확인 가능
    @Query(value = "SELECT * FROM todo WHERE userId = :userId", nativeQuery = true)
    List<Todo> findAllByUserId(Long userId);
}
