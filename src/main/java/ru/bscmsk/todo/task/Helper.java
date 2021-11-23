package ru.bscmsk.todo.task;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class Helper {

    public static String getParams(String readCommands) {
        return readCommands.replaceFirst("^\\S*", "").trim();
    }

    public static boolean isParamEmpty(IOut out, String... params) {
        if (Stream.of(params).anyMatch(String::isEmpty)) {
            out.printError("The parameter of command is not be empty.");
            return true;
        }
        return false;
    }
}
