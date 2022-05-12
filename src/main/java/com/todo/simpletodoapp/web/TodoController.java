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
        List<Todo> todos = todoService.todoList();
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
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
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        String userName = user.getName();

        Todo todo = new Todo();
        todo.setName(form.getName());
        todo.setTitle(form.getTitle());

        todoService.save(todo, userName);

        return "redirect:/";
    }

    @ResponseBody
    @PutMapping("/todo/{id}/edit")
    public void edit(@PathVariable("id") Long id,
                     @RequestBody TodoForm form) {
        System.out.println("TodoController.edit 호출됨");
        todoService.todoEdit(id, form);
    }

    @ResponseBody
    @PostMapping("/todo/{id}/update")
    public void stateUpdate(@PathVariable("id") Long id) {
        System.out.println("updateController 호출");
        todoService.stateUpdate(id);
    }

    @ResponseBody
    @DeleteMapping("/todo/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        System.out.println("TodoController.delete 호출");
        todoService.delete(id);
    }
}
