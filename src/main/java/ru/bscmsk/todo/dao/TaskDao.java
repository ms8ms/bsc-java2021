package ru.bscmsk.todo.dao;

import org.springframework.data.repository.CrudRepository;
import ru.bscmsk.todo.dto.TaskDto;

import java.util.List;

public interface TaskDao extends CrudRepository<TaskDto, Integer> {
    List<TaskDto> findByIsComplete(Boolean isComplete);

    List<TaskDto> findByDescriptionContains(String subString);
}
