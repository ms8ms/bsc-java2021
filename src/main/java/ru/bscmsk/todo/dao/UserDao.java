package ru.bscmsk.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bscmsk.todo.dto.UserDto;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserDto, Integer> {
    Optional<UserDto> findByLogin(String login);

}
