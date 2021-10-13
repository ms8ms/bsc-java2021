package ru.bscmsc.task1;

import lombok.Getter;

@Getter
public class Task {
    private final String description;
    private Boolean isComplete = false;

    public Task(String description) {
        this.description = description;
    }

    public void toggle() {
        isComplete = !isComplete;
    }
}
