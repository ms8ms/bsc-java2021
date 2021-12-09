package ru.bscmsk.todo.task;

import org.springframework.stereotype.Component;
import ru.bscmsk.todo.dto.TaskDto;
import ru.bscmsk.todo.enums.PrintVariant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TasksService {

    private final List<TaskDto> tasks = new ArrayList<>();

    public TaskDto add(String description) {
        TaskDto taskNew = new TaskDto(description, tasks.size() + 1);
        tasks.add(taskNew);
        return taskNew;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public List<TaskDto> getTasks(PrintVariant variant) {
        return variant == PrintVariant.ALL ? getTasks() : tasks.stream().filter((TaskDto::getIsNotComplete)).collect(Collectors.toList());
    }

    public List<TaskDto> getTasks(String substring) {
        return tasks.stream().filter(task -> task.getDescription().contains(substring)).collect(Collectors.toList());
    }

    public void remove(int taskId) {
        tasks.removeIf(t -> (taskId) == t.getIndex());
    }

    public TaskDto updateTask(int taskId, String description) {
        TaskDto taskDto = tasks.stream().filter(t -> (taskId) == t.getIndex()).findFirst().orElse(null);
        if (taskDto == null) return null;
        taskDto.setDescription(description);
        return taskDto;
    }

    public TaskDto toggle(int taskId) {
        TaskDto taskDto = tasks.stream().filter(t -> taskId == t.getIndex()).findFirst().orElse(null);
        if (taskDto == null) return null;
        taskDto.toggle();
        return taskDto;
    }
}
