package com.todo.simpletodoapp.web;

import com.todo.simpletodoapp.TodoService;
import com.todo.simpletodoapp.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        return "todoList";
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

    @ResponseBody
    @PostMapping("/todo/{id}/update")
    public void statusUpdate(@PathVariable("id") Long id) {
        System.out.println("updateContoller 호출");
        todoService.statusUpdate(id);
    }

    @ResponseBody
    @DeleteMapping("/todo/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        System.out.println("TodoController.delete 호출");
        todoService.delete(id);
    }
}
