package com.todo.simpletodoapp.web;

import com.todo.simpletodoapp.domain.TodoStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TodoForm {

    @NotEmpty(message = "이름을 넣어주세요!")
    private String name;
    @NotEmpty(message = "할 일을 넣어주세요!")
    private String title;
}
