package com.todo.simpletodoapp.domain;


import com.todo.simpletodoapp.web.TodoForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 250)
    private String title;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @ManyToOne(fetch = FetchType.LAZY) //Many = todo, User = One
    @JoinColumn(name = "user_id") //외래키
    private User user;

    @CreatedDate
    private String createDate;

    @CreatedDate
    private String editDate;

    @PrePersist
    public void onPrePersist() {
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.editDate = this.createDate;
    }

    @PreUpdate
    public void onPreUpdate() {
        this.editDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static Todo createTodo(TodoForm form) {
        Todo todo = new Todo();
        todo.setName(form.getName());
        todo.setTitle(form.getTitle());
        todo.setStatus(TodoStatus.TODO);
        return todo;
    }

}
