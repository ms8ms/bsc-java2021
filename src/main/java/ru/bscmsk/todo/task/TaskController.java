package ru.bscmsk.todo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bscmsk.todo.dto.TaskDto;
import ru.bscmsk.todo.enums.PrintVariant;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    private TasksService tasks;

    @PostMapping
    public TaskDto add(@RequestParam(value = "description") @NonNull String description) {
        return tasks.add(description);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            tasks.remove(Integer.parseInt(id));
            return ResponseEntity.noContent().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public TaskDto edit(@PathVariable String id, @NonNull @RequestParam(value = "description") String description) {
        TaskDto taskDto;
        try {
            taskDto = tasks.updateTask(Integer.parseInt(id), description);
            if (taskDto == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The task with the id was not found");
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id is not numbers");
        }
        return taskDto;
    }

    @PatchMapping("/{id}")
    public TaskDto toggle(@PathVariable String id) {
        TaskDto taskDto;
        try {
            taskDto = tasks.toggle(Integer.parseInt(id));
            if (taskDto == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The task with the id was not found");
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id is not numbers");
        }
        return taskDto;
    }

    @GetMapping
    public List<TaskDto> print(@RequestParam(value = "mode", required = false) PrintVariant printVariant) {
        return tasks.getTasks(printVariant);
    }

    @GetMapping("/search")
    public List<TaskDto> search(@RequestParam(value = "description") String description) {
        return tasks.getTasks(description);
    }

}
