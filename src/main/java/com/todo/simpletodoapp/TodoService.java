package com.todo.simpletodoapp;

import com.todo.simpletodoapp.domain.Todo;
import com.todo.simpletodoapp.domain.TodoRepository;
import com.todo.simpletodoapp.domain.TodoStatus;
import com.todo.simpletodoapp.web.TodoForm;
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

    @Transactional
    public void todoEdit(Long id, Todo todo) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("todo 찾기 실패");
                });
        findTodo.setTitle(todo.getTitle());
        findTodo.setName(todo.getName());

    }

    @Transactional
    public void statusUpdate(Long id) {
        Todo findTodo = todoRepository.getById(id);
        if(findTodo.getStatus().getVal() == "todo") {
            findTodo.setStatus(TodoStatus.DOING);
            System.out.println("doing 변경");
        } else if(findTodo.getStatus().getVal() == "doing") {
            findTodo.setStatus(TodoStatus.DONE);
            System.out.println("done으로 변경");

        }
    }

    @Transactional
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
