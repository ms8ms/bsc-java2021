package ru.bscmsk.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.bscmsk.todo.dto.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskDao extends JpaRepository<TaskDto, Integer> {

    @Query("from TaskDto t where t.user.id = ?1")
    List<TaskDto> findAll(int userId);

    @Query("from TaskDto t where t.user.id = ?2 and t.isComplete=?1")
    List<TaskDto> findByIsComplete(Boolean isComplete, int userId);

    @Query("from TaskDto t where t.user.id = ?2 and t.description like %?1%")
    List<TaskDto> findByDescriptionContains(String subString, int userId);

    @Query("from TaskDto t where t.user.id = ?2 and t.id = ?1")
    Optional<TaskDto> findById(Integer id, int userId);

    @Transactional
    @Modifying
    @Query("delete from TaskDto t where t.user.id = ?2 and t.id=?1")
    int deleteByTaskId(Integer taskId, int userId);
}
