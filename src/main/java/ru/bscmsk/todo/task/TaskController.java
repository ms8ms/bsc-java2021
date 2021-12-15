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
    @ResponseStatus(code = HttpStatus.CREATED)
    public TaskDto add(@RequestParam(value = "description") @NonNull String description) {
        return tasks.add(description);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        tasks.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public TaskDto edit(@PathVariable Integer id, @NonNull @RequestParam(value = "description") String description) {
        TaskDto taskDto = tasks.updateTask(id, description);
        if (taskDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return taskDto;
    }

    @PatchMapping("/{id}")
    public TaskDto toggle(@PathVariable Integer id) {
        TaskDto taskDto = tasks.toggle(id);
        if (taskDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
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
