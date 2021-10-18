package ru.bscmsc.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Command {
    ADD("add", "добавление задачи"),
    PRINT("print", "печать списка задач"),
    TOGGLE("toggle", "изменение статуса задачи"),
    QUIT("quit", "завершение работы"),
    ;

    private final String nameCommand;
    private final String description;

    public static Command byName(String name) {
        return Arrays.stream(Command.values())
                .filter(command -> name.equalsIgnoreCase(command.nameCommand)).findFirst().orElse(null);
    }
}
