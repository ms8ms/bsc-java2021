package ru.bscmsk.todo.task;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Tasks implements ITasks {

    private final List<Task> tasks = new ArrayList<>();

    public void add(String description) {
        tasks.add(new Task(description, tasks.size() + 1));
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getTasks(boolean isPrintAll) {

        return isPrintAll ? getTasks() : tasks.stream().filter((Task::getIsNotComplete)).collect(Collectors.toList());
    }

    public List<Task> getTasks(String substring) {
        return tasks.stream().filter(task -> task.getDescription().contains(substring)).collect(Collectors.toList());
    }

    public void remove(int taskId) {
        tasks.removeIf(t -> (taskId) == t.getIndex());
    }

    public void updateTask(int taskId, String description) {
        tasks.stream().filter(t -> (taskId) == t.getIndex())
                .forEach(t -> t.setDescription(description));
    }

    public void toggle(int taskId) {
        tasks.stream().filter(t -> taskId == t.getIndex()).findFirst().ifPresent(Task::toggle);
    }
}
