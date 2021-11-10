package ru.bscmsc.task;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
public class In implements IInput {
    private final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public String readCommand() {
        String command = scanner.readLine();
        log.debug("Entered command: {}", command);
        return command;
    }
}
