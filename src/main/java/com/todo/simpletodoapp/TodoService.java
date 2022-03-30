package com.todo.simpletodoapp;

import com.todo.simpletodoapp.domain.Todo;
import com.todo.simpletodoapp.domain.TodoRepository;
import com.todo.simpletodoapp.domain.TodoStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public void save(Todo todo) {
        todo.setStatus(TodoStatus.TODO);
        todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public List<Todo> todoList() {
        return todoRepository.findAll();
    }
}
