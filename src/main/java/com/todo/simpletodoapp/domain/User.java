package com.todo.simpletodoapp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

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

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }



}
