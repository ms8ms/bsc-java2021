package ru.bscmsk.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bscmsk.todo.dto.TaskDto;

import java.util.List;

public interface TaskDao extends JpaRepository<TaskDto, Integer> {
    List<TaskDto> findByIsComplete(Boolean isComplete);

    List<TaskDto> findByDescriptionContains(String subString);
}
