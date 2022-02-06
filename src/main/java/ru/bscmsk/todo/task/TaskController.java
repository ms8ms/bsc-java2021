package ru.bscmsk.todo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bscmsk.todo.dto.TaskDto;
import ru.bscmsk.todo.dto.UserDto;
import ru.bscmsk.todo.enums.PrintVariant;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("tasks")
public class TaskController {

    private final TasksService tasks;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TaskDto add(@RequestParam(value = "description") @NonNull String description,
                       @AuthenticationPrincipal UserDto user) {
        return tasks.add(description, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id,
                                    @AuthenticationPrincipal UserDto user) {
        tasks.remove(id, user.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public TaskDto edit(@PathVariable Integer id, @NonNull @RequestParam(value = "description") String description,
                        @AuthenticationPrincipal UserDto user) {
        TaskDto taskDto = tasks.updateDescription(id, description, user.getId());
        if (taskDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return taskDto;
    }

    @PatchMapping("/{id}")
    public TaskDto toggle(@PathVariable Integer id,
                          @AuthenticationPrincipal UserDto user) {
        TaskDto taskDto = tasks.toggle(id, user.getId());
        if (taskDto == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return taskDto;
    }

    @GetMapping
    public List<TaskDto> print(@RequestParam(value = "mode", required = false) PrintVariant printVariant,
                               @AuthenticationPrincipal UserDto user) {
        return tasks.getTasks(printVariant, user.getId());
    }

    @GetMapping("/search")
    public List<TaskDto> search(@RequestParam(value = "description") String description,
                                @AuthenticationPrincipal UserDto user) {
        return tasks.getTasks(description, user.getId());
    }

}
