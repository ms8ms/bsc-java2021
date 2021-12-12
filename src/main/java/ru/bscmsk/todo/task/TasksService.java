package ru.bscmsk.todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bscmsk.todo.dao.TaskDao;
import ru.bscmsk.todo.dto.TaskDto;
import ru.bscmsk.todo.enums.PrintVariant;

import java.util.List;
import java.util.function.Consumer;

@Component
public class TasksService {

    @Autowired
    private TaskDao tasks;

    public TaskDto add(String description) {
        TaskDto taskNew = new TaskDto();
        taskNew.setDescription(description);
        tasks.save(taskNew);
        return taskNew;
    }

    public List<TaskDto> getTasks(PrintVariant variant) {
        if (variant == PrintVariant.ALL) return (List<TaskDto>) tasks.findAll();
        return tasks.findByIsComplete(false);
    }

    public List<TaskDto> getTasks(String substring) {
        return tasks.findByDescriptionContains(substring);
    }

    public void remove(int taskId) {
        tasks.deleteById(taskId);
    }

    public TaskDto updateDescription(int taskId, String description) {
        return updateTask(taskId, t -> t.setDescription(description));
    }

    public TaskDto toggle(int taskId) {
        return updateTask(taskId, TaskDto::toggle);
    }

    private TaskDto updateTask(int taskId, Consumer<TaskDto> task) {
        TaskDto taskDto = tasks.findById(taskId).orElse(null);
        if (taskDto == null) return null;
        task.accept(taskDto);
        tasks.save(taskDto);
        return taskDto;
    }
}
