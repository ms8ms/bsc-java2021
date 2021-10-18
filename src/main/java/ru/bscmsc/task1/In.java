package ru.bscmsc.task1;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class In {
    private final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public String readCommand() {
        return scanner.readLine();
    }
}
