package ru.bscmsk.todo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bscmsk.todo.dao.TaskDao;
import ru.bscmsk.todo.dto.TaskDto;
import ru.bscmsk.todo.dto.UserDto;
import ru.bscmsk.todo.enums.PrintVariant;

import java.util.List;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class TasksService {

    private final TaskDao taskRepository;

    public TaskDto add(String description, UserDto user) {
        TaskDto taskNew = new TaskDto();
        taskNew.setDescription(description);
        taskNew.setUser(user);
        taskRepository.save(taskNew);
        return taskNew;
    }

    public List<TaskDto> getTasks(PrintVariant variant, int userId) {
        if (variant == PrintVariant.ALL) return taskRepository.findAll(userId);
        return taskRepository.findByIsComplete(false, userId);
    }

    public List<TaskDto> getTasks(String substring, int userId) {
        return taskRepository.findByDescriptionContains(substring, userId);
    }

    public int remove(int taskId, int userId) {
        return taskRepository.deleteByTaskId(taskId, userId);
    }

    public TaskDto updateDescription(int taskId, String description, int userId) {
        return updateTask(taskId, t -> t.setDescription(description), userId);
    }

    public TaskDto toggle(int taskId, int userId) {
        return updateTask(taskId, TaskDto::toggle, userId);
    }

    private TaskDto updateTask(int taskId, Consumer<TaskDto> taskAction, int userId) {
        return taskRepository.findById(taskId, userId)
                .map(t ->
                {
                    taskAction.accept(t);
                    return taskRepository.save(t);
                })
                .orElse(null);
    }
}
