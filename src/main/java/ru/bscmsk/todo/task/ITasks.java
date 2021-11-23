package ru.bscmsk.todo.task;

import java.util.List;

public interface ITasks {
    void add(String description);

    List<Task> getTasks();

    List<Task> getTasks(boolean isPrintAll);

    List<Task> getTasks(String substring);

    void remove(int taskId);

    void updateTask(int taskId, String description);

    void toggle(int taskId);
}
