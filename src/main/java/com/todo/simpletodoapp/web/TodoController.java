package com.todo.simpletodoapp.web;

import com.todo.simpletodoapp.TodoService;
import com.todo.simpletodoapp.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping({"/", "/todo"})
    public String main(Model model) {
        List<Todo> todos = todoService.todoList();
        model.addAttribute("todo", todos);
        return "main";
    }

    @GetMapping("/todo/new")
    public String createForm(Model model) {
        model.addAttribute("todoForm", new TodoForm());
        return "todoForm";
    }

    @PostMapping("/todo/new")
    public String save(@Valid TodoForm form, BindingResult result) {
        System.out.println("TodoController.save 호출됨");

        if(result.hasErrors()) {
            return "todoForm";
        }

        Todo todo = new Todo();
        todo.setName(form.getName());
        todo.setTitle(form.getTitle());
        todoService.save(todo);

        return "redirect:/";
    }
}
