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
    public void save(TodoForm form, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(()->{
            return new IllegalArgumentException("Email 찾기 실패");
        });

        Todo todo = Todo.createTodo(form);
        todo.setUser(user);
        todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public List<Todo> todoList(String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(()->{
            return new IllegalArgumentException("Email 찾기 실패");
        });
        Long userId = user.getId();
        return todoRepository.findAllByUserId(userId);
    }

    @Transactional
    public void todoEdit(Long id, TodoForm form) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("todo 찾기 실패");
                });
        findTodo.setTitle(form.getTitle());
        findTodo.setName(form.getName());
    }

    @Transactional
    public void stateUpdate(Long id) {
        Todo findTodo = todoRepository.getById(id);
        if(findTodo.getStatus().getVal() == "todo") {
            findTodo.setStatus(TodoStatus.DOING);
        } else if(findTodo.getStatus().getVal() == "doing") {
            findTodo.setStatus(TodoStatus.DONE);
        }
    }

    @Transactional
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
