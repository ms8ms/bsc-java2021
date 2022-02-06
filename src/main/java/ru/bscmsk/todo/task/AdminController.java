package ru.bscmsk.todo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.bscmsk.todo.dao.UserDao;
import ru.bscmsk.todo.dto.UserDto;
import ru.bscmsk.todo.enums.UserRole;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto createdUser(@RequestBody UserDto user) {
        user.setRole(UserRole.USER.name());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserDto userDto = userDao.save(user);
        userDto.setPassword("<hidden>");
        return userDto;
    }
}
