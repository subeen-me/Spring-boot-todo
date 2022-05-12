package com.todo.simpletodoapp.web;

import com.todo.simpletodoapp.TodoService;
import com.todo.simpletodoapp.config.auth.dto.SessionUser;
import com.todo.simpletodoapp.domain.Todo;
import com.todo.simpletodoapp.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String main(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            String userEmail = user.getEmail();
            List<Todo> todos = todoService.todoList(userEmail);
            model.addAttribute("userName", user.getName());
            model.addAttribute("todo", todos);
        }

        return "todoList";
    }

    @GetMapping("/todo/new")
    public String createForm(Model model) {
        model.addAttribute("todoForm", new TodoForm());
        return "todoForm";
    }

    @PostMapping("/todo/new")
    public String save(@Valid TodoForm form, BindingResult result) {
        if(result.hasErrors()) {
            return "todoForm";
        }
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        String userEmail = user.getEmail();

        Todo todo = new Todo();
        todo.setName(form.getName());
        todo.setTitle(form.getTitle());

        todoService.save(todo, userEmail);

        return "redirect:/";
    }

    @ResponseBody
    @PutMapping("/todo/{id}/edit")
    public void edit(@PathVariable("id") Long id,
                     @RequestBody TodoForm form) {
        todoService.todoEdit(id, form);
    }

    @ResponseBody
    @PostMapping("/todo/{id}/update")
    public void stateUpdate(@PathVariable("id") Long id) {
        todoService.stateUpdate(id);
    }

    @ResponseBody
    @DeleteMapping("/todo/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        todoService.delete(id);
    }
}
