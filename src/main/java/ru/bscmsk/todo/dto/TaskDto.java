package ru.bscmsk.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TaskDto {
    private final Integer index;
    @Setter
    private String description;
    private Boolean isNotComplete = true;

    public TaskDto(String description, Integer index) {
        this.description = description;
        this.index = index;
    }


    public void toggle() {
        isNotComplete = !isNotComplete;
    }

    @Override
    public String toString() {
        return String.format("%d. [%c] %s %n", getIndex(), getIsNotComplete() ? ' ' : 'x', getDescription());
    }
}
