package ru.bscmsk.todo.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    @JsonIgnore
    private UserDto user;

    public void toggle() {
        isComplete = !isComplete;
    }
}
