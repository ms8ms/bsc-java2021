package ru.bscmsk.todo.task;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Task {
    private final Integer index;
    @Setter
    private String description;
    private Boolean isNotComplete = true;

    public Task(String description, Integer index) {
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
