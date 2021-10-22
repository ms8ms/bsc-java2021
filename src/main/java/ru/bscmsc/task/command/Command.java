package ru.bscmsc.task.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Command {
    ADD("add", "добавление задачи", new Add()),
    PRINT("print", "печать списка задач", new Print()),
    TOGGLE("toggle", "изменение статуса задачи", new Toggle()),
    DELETE("delete", "удаления задачи из списка", new Delete()),
    EDIT("edit", "редактирования задачи", new Edit()),
    SEARCH("search", "поиска по подстроке", new Search()),
    QUIT("quit", "завершение работы", new Quit()),
    ;

    private final String nameCommand;
    private final String description;
    private final ICommand command;

    public static Command byName(String name) {
        return Arrays.stream(Command.values())
                .filter(command -> name.equalsIgnoreCase(command.nameCommand)).findFirst().orElse(null);
    }
}
