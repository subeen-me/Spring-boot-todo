package com.todo.simpletodoapp;

import com.todo.simpletodoapp.domain.*;
import com.todo.simpletodoapp.web.TodoForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(Todo todo, String userName) {
        todo.setStatus(TodoStatus.TODO);
        User user = userRepository.findByName(userName).orElseThrow(()->{
            return new IllegalArgumentException("name 찾기 실패");
        });
        todo.setUser(user);
        todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public List<Todo> todoList() {
        return todoRepository.findAll();
    }

    @Transactional
    public void todoEdit(Long id, TodoForm form) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("todo 찾기 실패");
                });
        findTodo.setTitle(form.getTitle());
        findTodo.setName(form.getName());
        System.out.println(form.getTitle());
        System.out.println(form.getName());

    }

    @Transactional
    public void stateUpdate(Long id) {
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
