package com.example.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(max = 100, message = "Task description maximum 100 symbols")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
