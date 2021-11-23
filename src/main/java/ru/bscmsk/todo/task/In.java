package ru.bscmsk.todo.task;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
@Service
public class In implements IInput {
    private final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public String readCommand() {
        String command = scanner.readLine();
        log.info("Entered command: {}", command);
        return command;
    }
}
