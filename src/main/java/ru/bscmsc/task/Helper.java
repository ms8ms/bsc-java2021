package ru.bscmsc.task;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class Helper {
    private static final Bean bean = new Bean();

    public static String getParams(String readCommands) {
        return readCommands.replaceFirst("^\\S*", "").trim();
    }

    public static boolean isParamEmpty(String... params) {
        if (Stream.of(params).anyMatch(String::isEmpty)) {
            bean.getOut().printError("The parameter of command is not be empty.");
            return true;
        }
        return false;
    }
}
