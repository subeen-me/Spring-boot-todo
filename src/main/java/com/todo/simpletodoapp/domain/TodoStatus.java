package com.todo.simpletodoapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TodoStatus {
    TODO("todo"), DOING("doing"), DONE("done");

    private String val;
}
