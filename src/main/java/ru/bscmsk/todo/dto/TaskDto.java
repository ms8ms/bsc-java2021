package ru.bscmsk.todo.dto;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class TaskDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    @Column(name = "is_complete")
    private Boolean isComplete = false;

    public void toggle() {
        isComplete = !isComplete;
    }
}
